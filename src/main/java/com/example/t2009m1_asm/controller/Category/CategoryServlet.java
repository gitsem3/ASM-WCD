package com.example.t2009m1_asm.controller.Category;

import com.example.t2009m1_asm.entity.Category;
import com.example.t2009m1_asm.model.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryServlet extends HttpServlet {
    private final MySqlCategoryModel categoryModel;

    public CategoryServlet() {
        categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryModel.getAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/admin/views/category/index.jsp").forward(request, response);
    }
}
