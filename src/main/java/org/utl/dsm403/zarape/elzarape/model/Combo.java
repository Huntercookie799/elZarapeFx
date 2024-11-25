package org.utl.dsm403.zarape.elzarape.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Combo {
    private final IntegerProperty idCombo;
    private final StringProperty nombre;
    private final DoubleProperty total;
    private final ObservableList<Producto> productos;

    public Combo() {
        this(0, "", 0.0);
    }

    public Combo(int idCombo, String nombre, double total) {
        this.idCombo = new SimpleIntegerProperty(idCombo);
        this.nombre = new SimpleStringProperty(nombre);
        this.total = new SimpleDoubleProperty(total);
        this.productos = FXCollections.observableArrayList();
    }

    // Getters y setters
    public int getIdCombo() { return idCombo.get(); }
    public void setIdCombo(int value) { idCombo.set(value); }
    public IntegerProperty idComboProperty() { return idCombo; }

    public String getNombre() { return nombre.get(); }
    public void setNombre(String value) { nombre.set(value); }
    public StringProperty nombreProperty() { return nombre; }

    public double getTotal() { return total.get(); }
    public void setTotal(double value) { total.set(value); }
    public DoubleProperty totalProperty() { return total; }

    public ObservableList<Producto> getProductos() { return productos; }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        actualizarTotal();
    }

    public void removerProducto(Producto producto) {
        productos.remove(producto);
        actualizarTotal();
    }

    private void actualizarTotal() {
        double nuevoTotal = productos.stream()
                                   .mapToDouble(Producto::getPrecio)
                                   .sum();
        setTotal(nuevoTotal);
    }

    @Override
    public String toString() {
        return nombre.get();
    }
} 