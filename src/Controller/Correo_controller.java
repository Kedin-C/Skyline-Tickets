/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Nikob
 */
import java.util.Properties;
import javax.swing.JOptionPane;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class Correo_controller {

    private String mensaje;
    private String cdestino;

    private final String correoRemitente = "skylineatickets@gmail.com";
    private final String contraseña = "mrxfgwsgbfqdgubt";
    private  String asunto;

    
    private Session crearSesion() {

        Properties propiedades = new Properties();

        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");

        Session sesion = Session.getInstance(
                propiedades,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(correoRemitente, contraseña);
                    }
                });

        sesion.setDebug(true);

        return sesion;
    }

 
    private void enviarCorreo() {

        try {

            Session sesion = crearSesion();

            MimeMessage correo = new MimeMessage(sesion);

            correo.setFrom(new InternetAddress(correoRemitente));

            correo.setRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(cdestino)
            );

            correo.setSubject(asunto);

            correo.setText(mensaje);

            Transport.send(correo);

            JOptionPane.showMessageDialog(
                    null,
                    "Correo enviado correctamente."
            );

        } catch (MessagingException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error al enviar el correo\n" + e.getMessage()
            );

            e.printStackTrace();
        }

    }

    
    public void enviarCodigoRecuperacion(String correoDestino, String codigo) {
        asunto = "Recuperar Contraseña";
        this.cdestino = correoDestino;

        this.mensaje =
                "Hola.\n\n"
                + "Has solicitado recuperar tu contraseña.\n\n"
                + "Tu código de recuperación es:\n\n"
                + codigo
                + "\n\n"
                + "Si no solicitaste este cambio, puedes ignorar este correo.\n\n"
                + "Skyline Tickets";

//        enviarCorreo();

    }
    
    public void enviarCodigoDescuento(String correoDestino, String codigo, int porcentaje) {
    this.cdestino = correoDestino;
    asunto = "Te tenemos un regalo!!";
    this.mensaje =
            "Hola.\n\n"
            + "Gracias por registrarte en Skyline Tickets.\n\n"
            + "Como bienvenida, te regalamos un código de descuento:\n\n"
            + "Código: " + codigo + "\n"
            + "Descuento: " + porcentaje + "%\n\n"
            + "¡Úsalo en tu próxima compra!\n\n"
            + "Skyline Tickets";
//    enviarCorreo();
}

}