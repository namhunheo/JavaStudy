package ch20.oracle.sec09.exam02;

import java.sql.Blob;
import java.util.Date;

import lombok.Data;

@Data
public class Board {
	private int bno;
	private String btitle;
	private String bcintent;
	private String bwriter;
	private Date bdate;
	private String userEmail;
	private Blob bfiledata;
}
