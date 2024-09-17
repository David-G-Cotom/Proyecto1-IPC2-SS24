/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model.anuncios;

import com.mycompany.proyecto1_ss24.backend.data.AnuncioDB;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Carlos Cotom
 */
public class MostrarAnunciosControler {

    private final AnuncioDB dataAnuncios = new AnuncioDB();
    private final ArrayList<Anuncio> anuncios;
    private final ArrayList<Anuncio> anunciosIzquierda = new ArrayList<>();
    private final ArrayList<Anuncio> anunciosDerecha = new ArrayList<>();
    private final int cantidadAnuncios;
    private final ArrayList<Integer> anunciosPosteados = new ArrayList<>();

    public MostrarAnunciosControler() {
        anuncios = dataAnuncios.getAllAnunciosActivos();
        cantidadAnuncios = anuncios.size();
        this.dividirAnuncios();
    }

    private void dividirAnuncios() {
        Random random = new Random();
        boolean tocaIzquierda = true;
        boolean anuncioRepetido;
        int anuncioAleatorio;
        int i = 0;
        do {
            do {
                anuncioRepetido = false;
                anuncioAleatorio = random.nextInt(cantidadAnuncios);
                for (Integer anuncioPosteado : anunciosPosteados) {
                    if (anuncioPosteado == anuncioAleatorio) {
                        anuncioRepetido = true;
                        break;
                    }
                }
                if (!anuncioRepetido) {
                    this.anunciosPosteados.add(anuncioAleatorio);
                }
            } while (anuncioRepetido);
            if (tocaIzquierda) {
                this.anunciosIzquierda.add(this.anuncios.get(anuncioAleatorio));
                tocaIzquierda = false;
            } else {
                this.anunciosDerecha.add(this.anuncios.get(anuncioAleatorio));
                tocaIzquierda = true;
            }
            i++;
        } while (i < this.cantidadAnuncios);
    }

    public ArrayList<Anuncio> getAnunciosIzquierda() {
        return anunciosIzquierda;
    }

    public ArrayList<Anuncio> getAnunciosDerecha() {
        return anunciosDerecha;
    }

}
