package com.javaweb.api;

import java.util.ArrayList;
import java.util.List;

public class ErroReponseDTO {
		private String error;
		private List<String> dateil = new ArrayList<String>();
		public String getError() {
			return error;
		}
		public void setError(String error) {
			this.error = error;
		}
		public List<String> getDateil() {
			return dateil;
		}
		public void setDateil(List<String> dateil) {
			this.dateil = dateil;
		}
		
		
		
}
