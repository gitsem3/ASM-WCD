package com.example.t2009m1_asm.controller.Product;

import com.example.t2009m1_asm.entity.Category;
import com.example.t2009m1_asm.entity.Product;
import com.example.t2009m1_asm.model.MySqlCategoryModel;
import com.example.t2009m1_asm.model.MySqlProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends HttpServlet {
    private final MySqlProductModel productModel;
    private final MySqlCategoryModel categoryModel;

    public ProductServlet() {
        productModel = new MySqlProductModel();
        categoryModel = new MySqlCategoryModel();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productModel.getAll();
        request.setAttribute("products", products);
        List<Category> categories = categoryModel.getAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/admin/views/product/index.jsp").forward(request, response);
    }

}
