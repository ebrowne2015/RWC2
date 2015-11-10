package com.example.eoinbrowne.rwc2;

import java.util.ArrayList;

/**
 * Created by EoinBrowne on 10/11/15.
 */
public class Controller {

    private static Controller _Instance;

    private Controller()
    {}

    public static Controller get_Instance()
    {

        if(_Instance == null)
        {

            _Instance = new Controller();

        }

        return _Instance;


    }

    // Method to check for duplication
    public  String checkForduplication(ArrayList<String> list)

    {
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = i + 1; j < list.size();j++)
            {
                if(list.get(i) == list.get(j))
                {
                    return "Error: Duplication found";
                }
            }

        }

        // no duplication
        return "No Duplication found";
    }




}
