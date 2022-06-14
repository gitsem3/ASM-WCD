package com.example.t2009m1_asm.controller.Product;

import com.example.t2009m1_asm.model.MySqlProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    private final MySqlProductModel productModel;
    public DeleteServlet() {
        productModel = new MySqlProductModel();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("productId"));
        boolean result = productModel.Delete(id);
        response.sendRedirect("/admin/product");
    }

}
