package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void openInputFile() {
    }

    @Test
    void sortAlphabetically() throws Exception{
        Main main = new Main();
        List<String> inputList_expected = new ArrayList<String>(Arrays.asList("BAKER, THEODORE","KENT, MADISON","SMITH, ANDREW","SMITH, FREDRICK"));
        List<String> inputList_actual = new ArrayList<String>(Arrays.asList("BAKER, THEODORE","SMITH, ANDREW","KENT, MADISON","SMITH, FREDRICK"));

        inputList_actual = main.SortAlphabetically(inputList_actual);

        main.SortAlphabetically(inputList_expected);
        assertEquals(inputList_expected, inputList_actual);
    }

    @Test
    void createOutputFile() {

    }
}