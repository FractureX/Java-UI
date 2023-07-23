/*
 * Proyecto M&M
 */
package com.mnm.view.component.table1.model;

import com.mnm.view.component.table1.view.PanelPaymentStatusLabel;

public class RowData {
    
    private class Nombre {
        
        private String nombre;
        private String correo;

        public Nombre(String nombre, String correo) {
            this.nombre = nombre;
            this.correo = correo;
        }
        
        public String getNombre() {
            return nombre;
        }
        
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        
        public String getCorreo() {
            return correo;
        }
        
        public void setCorreo(String correo) {
            this.correo = correo;
        }
        
    }
    
    private class Estatus_Usuario {
        
        private com.mnm.view.component.table1.view.PanelPaymentStatusLabel.StatusType statusType;
        private String lastLogin;
        
        public Estatus_Usuario(PanelPaymentStatusLabel.StatusType statusType, String lastLogin) {
            this.statusType = statusType;
            this.lastLogin = lastLogin;
        }
        
        public com.mnm.view.component.table1.view.PanelPaymentStatusLabel.StatusType getStatusType() {
            return statusType;
        }
        
        public void setStatusType(com.mnm.view.component.table1.view.PanelPaymentStatusLabel.StatusType statusType) {
            this.statusType = statusType;
        }
        
        public String getLastLogin() {
            return lastLogin;
        }
        
        public void setLastLogin(String lastLogin) {
            this.lastLogin = lastLogin;
        }
        
    }
    
    private class Estatus_Pago {
        
        private com.mnm.view.component.table1.view.PanelPaymentStatusLabel.StatusType statusType;
        private String ultimoPago;
        
        public Estatus_Pago(PanelPaymentStatusLabel.StatusType statusType, String ultimoPago) {
            this.statusType = statusType;
            this.ultimoPago = ultimoPago;
        }
        
        public com.mnm.view.component.table1.view.PanelPaymentStatusLabel.StatusType getStatusType() {
            return statusType;
        }
        
        public void setStatusType(com.mnm.view.component.table1.view.PanelPaymentStatusLabel.StatusType statusType) {
            this.statusType = statusType;
        }
        
        public String getUltimoPago() {
            return ultimoPago;
        }
        
        public void setUltimoPago(String ultimoPago) {
            this.ultimoPago = ultimoPago;
        }
        
    }
    
    private class Monto {
        
        private String monto;
        private String denominacion;
        
        public Monto(String monto, String denominacion) {
            this.monto = monto;
            this.denominacion = denominacion;
        }
        
        public String getMonto() {
            return monto;
        }
        
        public void setMonto(String monto) {
            this.monto = monto;
        }
        
        public String getDenominacion() {
            return denominacion;
        }
        
        public void setDenominacion(String denominacion) {
            this.denominacion = denominacion;
        }
        
    }
    
    private int id;
    private Nombre nombre;
    private Estatus_Usuario estatusUsuario;
    private Estatus_Pago estatusPago;
    private Monto monto;

    public RowData(int id, Nombre nombre, Estatus_Usuario estatusUsuario, Estatus_Pago estatusPago, Monto monto) {
        this.id = id;
        this.nombre = nombre;
        this.estatusUsuario = estatusUsuario;
        this.estatusPago = estatusPago;
        this.monto = monto;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Nombre getNombre() {
        return nombre;
    }
    
    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }
    
    public Estatus_Usuario getEstatusUsuario() {
        return estatusUsuario;
    }
    
    public void setEstatusUsuario(Estatus_Usuario estatusUsuario) {
        this.estatusUsuario = estatusUsuario;
    }
    
    public Estatus_Pago getEstatusPago() {
        return estatusPago;
    }
    
    public void setEstatusPago(Estatus_Pago estatusPago) {
        this.estatusPago = estatusPago;
    }
    
    public Monto getMonto() {
        return monto;
    }
    
    public void setMonto(Monto monto) {
        this.monto = monto;
    }
    
}
