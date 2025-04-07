package laba5;

import common.Response;

public class ResponseReader {
	void readResponse(Response response) {
		if (response.massage != null) {
			System.out.println(response.massage);
		}
		if (response.bands != null) {
			for(int i = 0; i < response.bands.length; i++) {
				System.out.println(response.bands[i]);
			}
		}
	}
}
