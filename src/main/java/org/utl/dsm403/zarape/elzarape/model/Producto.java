package org.utl.dsm403.zarape.elzarape.model;

import javafx.beans.property.*;

public class Producto {
    private final IntegerProperty idProducto;
    private final StringProperty nombre;
    private final StringProperty descripcion;
    private final StringProperty foto;
    private final DoubleProperty precio;
    private final IntegerProperty idCategoria;
    private final IntegerProperty activo;

    public Producto() {
        this(0, "", "", "", 0.0, 0, 1);
    }

    public Producto(int idProducto, String nombre, String descripcion, 
                   String foto, double precio, int idCategoria, int activo) {
        this.idProducto = new SimpleIntegerProperty(idProducto);
        this.nombre = new SimpleStringProperty(nombre);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.foto = new SimpleStringProperty(foto);
        this.precio = new SimpleDoubleProperty(precio);
        this.idCategoria = new SimpleIntegerProperty(idCategoria);
        this.activo = new SimpleIntegerProperty(activo);
    }

    // Getters y setters
    public int getIdProducto() { return idProducto.get(); }
    public void setIdProducto(int value) { idProducto.set(value); }
    public IntegerProperty idProductoProperty() { return idProducto; }

    public String getNombre() { return nombre.get(); }
    public void setNombre(String value) { nombre.set(value); }
    public StringProperty nombreProperty() { return nombre; }

    public String getDescripcion() { return descripcion.get(); }
    public void setDescripcion(String value) { descripcion.set(value); }
    public StringProperty descripcionProperty() { return descripcion; }

    public String getFoto() { return foto.get(); }
    public void setFoto(String value) { foto.set(value); }
    public StringProperty fotoProperty() { return foto; }

    public double getPrecio() { return precio.get(); }
    public void setPrecio(double value) { precio.set(value); }
    public DoubleProperty precioProperty() { return precio; }

    public int getIdCategoria() { return idCategoria.get(); }
    public void setIdCategoria(int value) { idCategoria.set(value); }
    public IntegerProperty idCategoriaProperty() { return idCategoria; }

    public int getActivo() { return activo.get(); }
    public void setActivo(int value) { activo.set(value); }
    public IntegerProperty activoProperty() { return activo; }

    @Override
    public String toString() {
        return nombre.get();
    }
} 