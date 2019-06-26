package mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class Demo01MB {

   private Integer numero1;
   private Integer numero2;
   private Integer resultado;

    public Integer getNumero1() {
        return numero1;
    }

    public void setNumero1(Integer numero1) {
        this.numero1 = numero1;
    }

    public Integer getNumero2() {
        return numero2;
    }

    public void setNumero2(Integer numero2) {
        this.numero2 = numero2;
    }

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }
   
   
    public void calcular(){
        this.resultado = this.numero1 + this.numero2;
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage("Calculado con exito..!");
        fc.addMessage(null, fm);
    }
    
}
