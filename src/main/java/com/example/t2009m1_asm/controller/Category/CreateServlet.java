package com.example.t2009m1_asm.controller.Category;

import com.example.t2009m1_asm.entity.Category;
import com.example.t2009m1_asm.entity.ObjStatus;
import com.example.t2009m1_asm.model.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateServlet extends HttpServlet {
    private final MySqlCategoryModel categoryModel;
    public CreateServlet() {
        categoryModel = new MySqlCategoryModel();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String status = req.getParameter("status");
        ObjStatus statusValue = ObjStatus.ACTIVE;
        if(status  == null) {
            statusValue = ObjStatus.DEACTIVE;
        }
        Category category = new Category();
        category.setName(name);
        category.setStatus(statusValue);
        boolean result = categoryModel.Save(category);
        resp.sendRedirect("/admin/category");
    }
}