package ru.kpfu.itis.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.UserRepositoryImpl;
import ru.kpfu.itis.services.UserService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.Objects;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@MultipartConfig
@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {

    private UserRepositoryImpl userRepository;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userRepository = (UserRepositoryImpl) getServletContext().getAttribute("userRepository");
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/views/security/profile.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User oldUser = userService.getUser(request,response);
        Long id = userRepository.getUserId(oldUser.getEmail(),oldUser.getUsername(),oldUser.getPassword());
        String oldImage = oldUser.getImage();

        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Part filePart = request.getPart("image");

        String image = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        if(email != null && password != null && username != null) {
            if(!email.contains("@")) {
                request.setAttribute("message","Email must contain @");
            } else if (userRepository.emailExist(email) && (!Objects.equals(oldUser.getEmail(), email))) {
                request.setAttribute("message","This email is already taken");
            } else if (userRepository.usernameExist(username) && (!Objects.equals(oldUser.getUsername(), username)))  {
                request.setAttribute("message","This username is already taken");
            } else {
                if (!image.equals("")) {
                    File uploads = new File("D:\\FlatSharing\\src\\main\\webapp\\images\\user");
                    File file = new File(uploads, image );
                    try (InputStream fileContent = filePart.getInputStream()) {
                        Files.copy(fileContent, file.toPath(),REPLACE_EXISTING);
                    }
                } else {
                    image = oldImage;
                }
                User user = new User(email,username,password,image,"client");
                userRepository.update(user,id);
                userService.auth(user,request,response);
                response.sendRedirect("/flats/profile");
                return;
            }
        } else {
            request.setAttribute("message","You have to fill all fields");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/views/security/profile.jsp").forward(request,response);
    }
}

