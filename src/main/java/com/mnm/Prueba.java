/*
 * Proyecto M&M
 */
package com.mnm;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prueba {
    
    public class Fruta {
        private String nombre;
        private String origen;

        public Fruta(String nombre, String origen) {
            this.nombre = nombre;
            this.origen = origen;
        }
        
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getOrigen() {
            return origen;
        }

        public void setOrigen(String origen) {
            this.origen = origen;
        }
    }
    
    public Prueba() {
        System.out.println("Fruta.class.getClasses()");
        for (int i = 0; i < Fruta.class.getClasses().length; i++) {
            System.out.println("Fruta.class.getClasses()[" + i + "]: " + Fruta.class.getClasses()[i]);
        }
        System.out.println("Fruta.class.getDeclaredFields()");
        for (int i = 0; i < Fruta.class.getDeclaredFields().length; i++) {
            System.out.println("Fruta.class.getDeclaredFields()[" + i + "]: " + Fruta.class.getDeclaredFields()[i]);
        }
        List<Fruta> frutas = new ArrayList<>();
        frutas.add(new Fruta("Aguacate", "Venezuela"));
        frutas.add(new Fruta("Cambur", "Colombia"));
        frutas.add(new Fruta("Aguacate 2", "Venezuela"));
        frutas.add(new Fruta("Cambur 2", "Colombia"));
        frutas.add(new Fruta("Aguacate 3", "Venezuela"));
        frutas.add(new Fruta("Cambur 3", "Colombia"));
        getAttributeList(frutas, Fruta.class, "nombre");
    }
    
    public <T, Q> List<T> getAttributeList(List list, Class<? extends Q> clazz, String attribute) {
        List<T> attrList= new ArrayList<T>();
        
        attribute = String.valueOf(attribute.charAt(0)).toUpperCase() + attribute.substring(1); 
        String methodName = "get"+attribute;
        
        for(Object obj: list){
            T aux = null;
            try {
                aux = (T)clazz.getDeclaredMethod(methodName, new Class[0]).invoke(obj, new Object[0]);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
            }
            attrList.add(aux);
        }
        System.out.println("attrList: " + attrList.toString());
        return attrList;
    }
}
