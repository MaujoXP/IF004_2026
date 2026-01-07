/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Mauricio
 */
public class RussianMultiplicationModel { 
    public long multiply(long a, long b) { 
        long x = Math.abs(a); 
        long y = Math.abs(b); 
        long sum = 0; 
        while (x != 0) { 
            if (x % 2 == 1) { 
                sum += y; 
            } 
            x = x / 2; 
            y = y * 2; 
        } 
        return sum; 
    }
}