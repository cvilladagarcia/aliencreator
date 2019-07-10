package com.millenium.bots.whatsapp.enviarmensaje.dao;

import java.util.ArrayList;
import java.util.List;

import com.millenium.bots.common.dao.GenericDAO;
import com.millenium.bots.whatsapp.enviarmensaje.models.SmsOutBound;

/**
 * SmsOutBoundDAO
 *
 * @author cavillada
 * @date Apr 9, 2018
 */
public class SmsOutBoundDAO extends GenericDAO<SmsOutBound> {

	/**
	 * 
	 */
	public SmsOutBoundDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public SmsOutBound getSmsOutBound() {
		String sql = "SELECT sms.id, mensaje, destino FROM " + getSchema() + ".smsoutbound sms"
				+ " inner join " + getSchema() + ".smslista lis on lis.id = sms.smslista_id"
				+ " where lis.categoria = 'whatsapp' and estado = 'PENDIENTE'"
				+ " ORDER BY id desc LIMIT 1 ";
		return querySelect(sql, null);
	}
	
	public boolean actualizarEstadoBot(long id, String estado) {
		List<Object> params =  new ArrayList<>();
		params.add(estado);
		params.add(id);
		return update("UPDATE " + getSchema() +  ".smsoutbound set estado = ?, fechaestado = now() where id = ?", params);
	}
	
	public boolean pasarPendiente(String estadoBotNew, String estadobotOld){
		List<Object> params = new ArrayList<Object>();
		params.add(estadoBotNew);
		params.add(estadobotOld);
		return update("UPDATE " + getSchema() +  ".smsoutbound set estado = ? where estado = ?",params);
	}

}
