package com.millenium.bots.whatsapp.enviarmensaje;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.log4j.Logger;


/**
 * SendMessage
 *
 * @author cavillada
 * @date Apr 5, 2018
 */
public class SendMessage {

	private static Logger logger = Logger.getLogger(SendMessage.class);
	
	/**
	 * 
	 */
	public SendMessage() {
	}
	
	public static void closeAll() throws IOException {
		Navigation.killBrowser();
		Navigation.getAhkFunctions().delayms(5000);
	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

//		SmsOutBoundDAO smsOutBoundDAO = new SmsOutBoundDAO();
//		SmsOutBound smsOutBound = null;
		
//		try {
//			Navigation.killBots();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		closeAll();
		
//		Runnable runnableBotDetenido = new Runnable(){
//			public void run(){
//				while (true) {
//					try {
//						Thread.sleep(300000);
//						InetAddress address = InetAddress.getLocalHost();
//						String ip2 = address.getHostAddress();
//						ReferenciacionCobisBOT referenciacionCobisBOT = new ReferenciacionCobisBOTDAO().getIpBotDetenido(ip2);
//						if (referenciacionCobisBOT != null) {
//							if (referenciacionCobisBOT.getIpDetenida().equalsIgnoreCase(ip2)) {
//								System.exit(0);
//							}
//						}
//					} catch (InterruptedException | UnknownHostException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		};
//		
//		Thread threadBotDetenido = new Thread(runnableBotDetenido);
		
//		int sendMessageToMe = 0;
		boolean ciclo = true;
//		int intento = 1;
		int numeroMensaje = 1;
		
		while (ciclo) {
			
//			smsOutBound = smsOutBoundDAO.getSmsOutBound();
			
//			if (smsOutBound == null) {
//				
//				smsOutBoundDAO.pasarPendiente("PENDIENTE", "ERROR");
//				
//				Thread.sleep(1000);
//				
//				sendMessageToMe++;
//				
//				if (sendMessageToMe == 300) {
//					Navigation.enterWhatsApp("https://api.whatsapp.com/send?phone=573117993326&text=" + URLEncoder.encode("Cristhian aun sigo vivo. "+intento +" 0xF0 0x9F 0x98 0x80 (f09f9880)", "UTF-8").replaceAll("\\+", "%20"));
//					Thread.sleep(1000);
//					Navigation.killDriver();
//					logger.info("Mensaje de prueba enviado "+intento);
//					intento++;
//					sendMessageToMe = 0;
//				}
//				continue;
//			}
//			
//			logger.info("Celular destino: " + smsOutBound.getDestino());
			
			String destino = "573506038794";
			
			String mensaje = "¡¡Hello World!! " + numeroMensaje;
		
			if (Navigation.enterWhatsApp("https://api.whatsapp.com/send?phone=" + /*smsOutBound.getDestino()*/destino + "&text=" + URLEncoder.encode(/*smsOutBound.getMensaje()*/mensaje, "UTF-8").replaceAll("\\+", "%20"))) {
				logger.info("Mensaje #" + numeroMensaje + " enviado al número" + destino);
				numeroMensaje++;
//				logger.info("Se envio con exito el mensaje al celular "+smsOutBound.getDestino()+" por whatsapp.");
//				smsOutBoundDAO.actualizarEstadoBot(smsOutBound.getId(), "ENVIADO");
			} else {
//				logger.info("No se pudo enviar el mensaje al celular "+smsOutBound.getDestino()+" por whatsapp.");
//				smsOutBoundDAO.actualizarEstadoBot(smsOutBound.getId(), "ERROR");
			}
			Navigation.killDriver();
		}
	}
}
