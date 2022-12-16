<%--
  Created by IntelliJ IDEA.
  User: Volobuev
  Date: 21.11.2022
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:mainLayout title ="Main page">
    <div class="text-info">Current offers: ${flatCount} </div>
    <section style="background-color: #eee;">
        <div class="container py-5">
            <c:forEach items="${flats}" var="flat">
                <div class="row justify-content-center mb-3">
                    <div class="col-md-12 col-xl-10">
                        <div class="card shadow-0 border rounded-3">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-12 col-lg-3 col-xl-3 mb-4 mb-lg-0">
                                        <div class="bg-image hover-zoom ripple rounded ripple-surface">
                                            <a href="<c:url value="/flat/detail?id=${flat.id}"/>">
                                                <img src="${pageContext.request.contextPath}/images/flat/${flat.getImage()}"
                                                     class="w-100" height="170px" width="280px"/>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-lg-6 col-xl-6">
                                        <h5>${flat.getFlatName()}</h5>
                                        <div class="mt-1 mb-0 text-muted small">
                                            <span>${flat.getStatus()}</span>
                                            <span class="text-primary"> • </span>
                                            <span>${flat.getLocation()}</span>
                                            <span class="text-primary"> • </span>
                                            <span>${flat.getCost()}<br /></span>
                                        </div>
                                        <p class="text-truncate mb-4 mb-md-0">
                                            There are many variations of passages of Lorem Ipsum available, but the
                                            majority have suffered alteration in some form, by injected humour, or
                                            randomised words which don't look even slightly believable.
                                        </p>
                                    </div>
                                    <div class="col-md-6 col-lg-3 col-xl-3 border-sm-start-none border-start">
                                        <div class="d-flex flex-row align-items-center mb-1">
                                            <h4 class="mb-1 me-1">${flat.getCost()}</h4>
                                        </div>
                                        <div class="d-flex flex-column mt-4">
                                            <a href="<c:url value="/flat/detail?id=${flat.id}"/>">
                                                <button class="btn btn-primary btn-sm" type="submit">Details</button>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><br>
            </c:forEach>
        </div>
    </section>
</t:mainLayout>

