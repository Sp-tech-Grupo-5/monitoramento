/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author raylane
 */
public class ModelComponentes {
    private Integer id;
    private Double cpuCompPor;
    private Double memoriaGb;
    private Double discoGb;

    public Double getCpuCompPor() {
        return cpuCompPor;
    }

    public void setCpuCompPor(Double cpuCompPor) {
        this.cpuCompPor = cpuCompPor;
    }

    public Double getMemoriaGb() {
        return memoriaGb;
    }

    public void setMemoriaGb(Double memoriaGb) {
        this.memoriaGb = memoriaGb;
    }

    public Double getDiscoGb() {
        return discoGb;
    }

    public void setDiscoGb(Double discoGb) {
        this.discoGb = discoGb;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    

    @Override
    public String toString() {
        return "ModelComponentes{" + "id=" + id + ", cpuCompPor=" + cpuCompPor + ", memoriaGb=" + memoriaGb + ", discoGb=" + discoGb + '}';
    }
    
    
    
}
