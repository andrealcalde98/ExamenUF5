/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author analc
 */
class ProductComparator implements Comparator<ProductItem> {

    @Override
    public int compare(ProductItem p1, ProductItem p2) {
        if (p1.getId() < p2.getId()) {
            return -1;
        } else if (p1.getId() == p2.getId()) {
            return 0;
        } else {
            return 1;
        }
    }
}

//Crea la classe ProductItem amb les propietats: id, name i description.
//La classe ProductItem ha d'implementar la interficie Comparable segons el camps "id".
//Crea una llista de tipus ProductItem, afegeix 10 elements i ordena-la per id"
//Recòrre la llista i escriu els productes amb el nom "ref" seguit d'un numero de tres digits, 
//per exemple: ref001. Usa una expressió regular.
public class Examen {

    public static boolean ValidateName(String name) {
        Pattern p = Pattern.compile("^ref\\d{3}");
        Matcher m = p.matcher(name);
        return m.matches();
    }

    public static void main(String[] args) {

        List<ProductItem> list = new ArrayList<>();

        list.add(new ProductItem(1, "refabc", "Gran"));
        list.add(new ProductItem(5, "ref005", "Petit"));
        list.add(new ProductItem(4, "ref002", "Mitja"));
        list.add(new ProductItem(3, "ref003", "Gran"));
        list.add(new ProductItem(2, "ref004", "Gran"));
        Collections.sort(list, new ProductComparator());

        // Iteració per ordenar el valors per 'id' i mostrar unicament els Productes que tenen una "ref" vàlid. 
        for (ProductItem productItem : list) {
            boolean m = ValidateName(productItem.getName());
            //System.out.println(m);
            if (m == false) {
                System.out.println("Aquest no cumpleix el requisit, " + "Id: " + productItem.getId());
            } else {
                System.out.println(productItem);
            }

        }

    }

}
