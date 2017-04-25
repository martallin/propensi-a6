package mosing.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JalurMasukModel {
	private int id_jalur;
	private String nama;
	private Date tanggal_buka;
	private Date tanggal_tutup;
	private int status;
	private String nama_jenjang;
	private String nama_program;
	private byte jenis_jalur;
	private String persyaratan;
	private int flag_aktif;
	private List<ProdiModel> listProdi;
}
