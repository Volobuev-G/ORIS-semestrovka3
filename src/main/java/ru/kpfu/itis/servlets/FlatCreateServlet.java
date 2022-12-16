package ru.kpfu.itis.servlets;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import ru.kpfu.itis.models.Flat;
import ru.kpfu.itis.repositories.FlatRepositoryImpl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@MultipartConfig
@WebServlet(name = "FlatCreateServlet", value = "/flat/create")
public class FlatCreateServlet extends HttpServlet {

    private FlatRepositoryImpl flatRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        flatRepository = (FlatRepositoryImpl) getServletContext().getAttribute("flatRepository");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/views/flats/create.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String status = request.getParameter("status");
        String location = request.getParameter("location");
        String cost = request.getParameter("cost");

        Part filePart = request.getPart("image");

        String image = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        if(!Objects.equals(name, "") && !Objects.equals(status, "") && !Objects.equals(location, "") && !Objects.equals(cost, "")) {
            if (!image.equals("")) {
                File uploads = new File("D:\\FlatSharing\\src\\main\\webapp\\images\\flat");
                File file = new File(uploads, image );
                try (InputStream fileContent = filePart.getInputStream()) {
                    Files.copy(fileContent, file.toPath(),REPLACE_EXISTING);
                }
            } else {
                image = null;
            }
            Flat flat = new Flat(name,image,status,location,Integer.parseInt(cost));
            flatRepository.save(flat);
            response.sendRedirect("/flats/flat/list/");
            return;
        } else {
            request.setAttribute("message","You have to fill all fields");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/views/flats/create.jsp").forward(request,response);
    }
}
