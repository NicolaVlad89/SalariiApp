package com.nicolavlad.domain;

public class Employee {

    private String prenume;
    private String nume;
    private float salariuBrut;
    private int oreLucrate;
    private int oreSuplimentare;
    private float cas;// = (float) (salariuBrut * 0.105);
    private float sanatate;// = (float) (salariuBrut * 0.055);
    private float somaj;// = (float) (salariuBrut * 0.005);
    private float salariuNet;// = salariuBrut - cas - sanatate - somaj;
    private int id;

    public Employee(String prenume, String nume, float salariuBrut, int oreLucrate, int oreSuplimentare, float cas, float sanatate, float somaj, float salariuNet, int id) {
        this.prenume = prenume;
        this.nume = nume;
        this.salariuBrut = salariuBrut;
        this.oreLucrate = oreLucrate;
        this.oreSuplimentare = oreSuplimentare;
        this.cas = cas;
        this.sanatate = sanatate;
        this.somaj = somaj;
        this.salariuNet = salariuNet;
        this.id = id;
    }

    public Employee() {

    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public float getSalariuBrut() {
        return salariuBrut;
    }

    public void setSalariuBrut(float salariuBrut) {
        this.salariuBrut = salariuBrut;
    }

    public int getOreLucrate() {
        return oreLucrate;
    }

    public void setOreLucrate(int oreLucrate) {
        this.oreLucrate = oreLucrate;
    }

    public int getOreSuplimentare() {
        return oreSuplimentare;
    }

    public void setOreSuplimentare(int oreSuplimentare) {
        this.oreSuplimentare = oreSuplimentare;
    }

    public float getCas() {
        return cas;
    }

    public void setCas(float cas) {
        this.cas = cas;
    }

    public float getSanatate() {
        return sanatate;
    }

    public void setSanatate(float sanatate) {
        this.sanatate = sanatate;
    }

    public float getSomaj() {
        return somaj;
    }

    public void setSomaj(float somaj) {
        this.somaj = somaj;
    }

    public float getSalariuNet() {
        return salariuNet;
    }

    public void setSalariuNet(float salariuNet) {
        this.salariuNet = salariuNet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void calculateTaxes(Employee employee) {
        employee.cas = (float) (employee.salariuBrut * 0.105);
        employee.sanatate = (float) (employee.salariuBrut * 0.055);
        employee.somaj = (float) (employee.salariuBrut * 0.005);
        employee.salariuNet = employee.salariuBrut - employee.cas - employee.sanatate - employee.somaj;
    }

}
