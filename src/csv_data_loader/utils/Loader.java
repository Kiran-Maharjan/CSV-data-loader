/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv_data_loader.utils;

import java.io.IOException;

/**
 *
 * @author kiran
 */
public abstract class Loader {
    public abstract void load(String filename) throws IOException;
}
