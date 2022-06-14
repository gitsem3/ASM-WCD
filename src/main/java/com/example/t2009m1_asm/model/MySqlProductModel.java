package com.example.t2009m1_asm.model;

import com.example.t2009m1_asm.constant.SqlConstant;
import com.example.t2009m1_asm.entity.Product;
import com.example.t2009m1_asm.entity.ProductStatus;
import com.example.t2009m1_asm.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductModel implements ProductModel {
    Connection connection = ConnectionHelper.getConnection();

    @Override
    public boolean Save(Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_INSERT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getImage());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getCategoryId());
            preparedStatement.setString(6, product.getOpeningDate().toString());
            preparedStatement.setInt(7, product.getStatus().getValue());
            preparedStatement.setString(8, product.getCreatedAt().toString());
            preparedStatement.setString(9, product.getUpdatedAt().toString());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product category = new Product();
                category.setId(resultSet.getInt(SqlConstant.PRODUCT_FIELD_ID));
                category.setName(resultSet.getString(SqlConstant.PRODUCT_FIELD_NAME));
                category.setDescription(resultSet.getString(SqlConstant.PRODUCT_FIELD_DESCRIPTION));
                category.setImage(resultSet.getString(SqlConstant.PRODUCT_FIELD_IMAGE));
                category.setPrice(resultSet.getDouble(SqlConstant.PRODUCT_FIELD_PRICE));
                category.setCategoryId(resultSet.getInt(SqlConstant.PRODUCT_FIELD_CATEGORY_ID));
                category.setOpeningDate(resultSet.getTimestamp(SqlConstant.PRODUCT_FIELD_OPENING_DATE).toLocalDateTime());
                category.setStatus(ProductStatus.getAccountStatus(resultSet.getInt(SqlConstant.PRODUCT_FIELD_STATUS)));
                products.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt(SqlConstant.PRODUCT_FIELD_ID));
                product.setName(resultSet.getString(SqlConstant.PRODUCT_FIELD_NAME));
                product.setDescription(resultSet.getString(SqlConstant.PRODUCT_FIELD_DESCRIPTION));
                product.setImage(resultSet.getString(SqlConstant.PRODUCT_FIELD_IMAGE));
                product.setPrice(resultSet.getDouble(SqlConstant.PRODUCT_FIELD_PRICE));
                product.setCategoryId(resultSet.getInt(SqlConstant.PRODUCT_FIELD_CATEGORY_ID));
                product.setOpeningDate(resultSet.getTimestamp(SqlConstant.PRODUCT_FIELD_OPENING_DATE).toLocalDateTime());
                product.setStatus(ProductStatus.getAccountStatus(resultSet.getInt(SqlConstant.PRODUCT_FIELD_STATUS)));
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean Update(int id, Product productUpdate) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_UPDATE);
            preparedStatement.setString(1, productUpdate.getName());
            preparedStatement.setString(2, productUpdate.getDescription());
            preparedStatement.setString(3, productUpdate.getImage());
            preparedStatement.setDouble(4, productUpdate.getPrice());
            preparedStatement.setInt(5, productUpdate.getCategoryId());
            preparedStatement.setString(6, productUpdate.getOpeningDate().toString());
            preparedStatement.setString(7, productUpdate.getUpdatedAt().toString());
            preparedStatement.setInt(8, productUpdate.getStatus().getValue());
            preparedStatement.setInt(9, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_DELETE);
            preparedStatement.setInt(1, ProductStatus.DELETED.getValue());
            preparedStatement.setString(2, LocalDateTime.now().toString());
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
