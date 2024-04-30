/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movago;

public class FormManager {
    private static MainForm mainFormInstance;

    public static MainForm getMainFormInstance() {
        if (mainFormInstance == null) {
            mainFormInstance = new MainForm();
        }
        return mainFormInstance;
    }
}
