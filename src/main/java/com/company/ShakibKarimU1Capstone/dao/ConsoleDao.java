package com.company.ShakibKarimU1Capstone.dao;



import com.company.ShakibKarimU1Capstone.model.Console;

import java.util.List;

public interface ConsoleDao {

    Console createConsole(Console console);

    Console getConsole(int consoleId);

    List<Console> getAllConsoles();

    void updateConsole(Console console);

    void deleteConsole(int consoleId);

    List<Console> getConsoleByManufacturer(String manufacturer);


}
