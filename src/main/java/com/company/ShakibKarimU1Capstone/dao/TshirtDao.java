package com.company.ShakibKarimU1Capstone.dao;



import com.company.ShakibKarimU1Capstone.model.TShirt;

import java.util.List;

public interface TshirtDao {

    TShirt createTshirt(TShirt tshirt);

    TShirt getTshirt(int tShirtId);

    List<TShirt> getAllTshirts();

    void updateTshirt(TShirt tshirt);

    void deleteTshirt(int tShirtId);

    List<TShirt> getTshirtByColor(String color);

    List<TShirt> getTshirtBySize(String size);


}
