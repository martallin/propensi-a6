package mosing.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import mosing.model.DaftarPilihanModel;
import mosing.model.PendaftarModel;

@Mapper
public interface PendaftarMapper {

	@Select("SELECT u.id_user, u.username, p.* FROM USER u, PENDAFTAR p WHERE u.username = #{username} AND u.id_user = p.id_user")
	PendaftarModel selectPendaftar2(@Param("username") String username);

	@Select("SELECT * FROM PENDAFTAR WHERE no_id=#{no_id}")
	PendaftarModel selectPendaftar(@Param("no_id") String no_id);

	@Insert("INSERT INTO PENDAFTAR (id_user, no_id, nama_id, "
			+ "nama_ijazah, foto, no_hp, no_telp, nama_negara, kewarganegaraan, alamat_tetap, "
			+ "jenis_id, alamat_sekarang, tgl_lahir, nama_provinsi, nama_kota, jenis_kelamin, nama_lembaga, jurusan) VALUES"
			+ "(#{id_user}, #{no_id}, #{nama_id}, "
			+ "#{nama_ijazah}, #{foto}, #{no_hp}, #{no_telp}, #{nama_negara}, #{kewarganegaraan},"
			+ "#{alamat_tetap}, #{jenis_id}, #{alamat_sekarang}, #{tgl_lahir}, #{nama_provinsi}, "
			+ "#{nama_kota}, #{jenis_kelamin}, #{nama_lembaga}, #{jurusan})")
	void addPendaftar(PendaftarModel pendaftar);

	@Insert("INSERT INTO DAFTAR_PILIHAN (no_daftar, jenjang, nama_program, id_prodi, pilihan) VALUES "
			+ "(#{no_daftar}, #{jenjang}, #{nama_program}, #{id_prodi}, #{pilihan})")
	void addDaftarPilihan(DaftarPilihanModel daftar);

	@Update("UPDATE PENDAFTAR SET foto=#{foto} WHERE id_user=#{id_user}")
	void updateFoto(@Param("foto") String foto, @Param("id_user") int id_user);

	@Select("SELECT * FROM PENDAFTAR p" 
			+ " JOIN PENYELEKSIAN ON p.no_daftar = PENYELEKSIAN.no_daftar"
			+ " JOIN USER ON p.id_user = USER.id_user"
			+ " WHERE penyeleksian.status=0 AND id_jalur=4 AND USER.email IS NOT NULL")
	List<PendaftarModel> selectAllPendaftarTerverifikasi();

	@Select("SELECT * FROM PENDAFTAR p"
			+ " JOIN PENYELEKSIAN ON p.no_daftar = PENYELEKSIAN.no_daftar"
			+ " JOIN USER ON p.id_user = USER.id_user"
			+ " WHERE penyeleksian.status=0 AND id_jalur=4 AND USER.email IS NULL")
	List<PendaftarModel> selectAllPendaftarTakTerverifikasi();

	@Select("SELECT nama_id, no_id, jurusan, penyeleksian.status AS status FROM PENDAFTAR"
			+ " JOIN PENYELEKSIAN ON pendaftar.no_daftar = penyeleksian.no_daftar"
			+ " JOIN JALUR_MASUK ON penyeleksian.id_jalur = jalur_masuk.id_jalur")
	@Results(value = { @Result(property = "nama_id", column = "nama_id"), @Result(property = "no_id", column = "no_id"),
			@Result(property = "jurusan", column = "jurusan") })
	List<PendaftarModel> selectAllPendaftar();

	@Update("UPDATE PENDAFTAR SET nama_id = #{nama_id}, nama_ijazah=#{nama_ijazah}, jenis_kelamin=#{jenis_kelamin}, no_id=#{no_id}, "
			+ "nama_lembaga=#{nama_lembaga}, jurusan=#{jurusan} WHERE no_daftar=#{no_daftar}")
	void updateDataPendaftar(PendaftarModel pendaftar);
	
	@Select("select p.* from pendaftar p join penyeleksian pn on pn.no_daftar=p.no_daftar join daftar_pilihan d on pn.no_daftar=d.no_daftar join prodi_tersedia pr on "
			+ "pr.id_prodi = d.id_prodi where pn.status_rekomen=0 and d.id_prodi = #{id_prodi}")
	List<PendaftarModel> selectAllPendaftarNonRec(@Param("id_prodi") int id_prodi);

	@Select("select * from pendaftar join penyeleksian on pendaftar.no_daftar = penyeleksian.no_daftar"
			+ "join nilai_rapor on penyeleksian.no_daftar = nilai_rapor.no_daftar"
			+ "where penyeleksian.id_jalur = 4")
	@Results(value = {
			@Result(property = "nama_id", column = "nama_id"),
			@Result(property = "no_daftar", column = "no_daftar"),
			@Result(property = "nama_lembaga", column = "nama_lembaga"),
			@Result(property = "status_rekomen", column = "status_rekomen")
	})
	List<PendaftarModel> selectAllPendaftarPPKB();

	@Select("select p.* from pendaftar p join penyeleksian pn on pn.no_daftar=p.no_daftar join daftar_pilihan d on pn.no_daftar=d.no_daftar join prodi_tersedia pr on "
			+ "pr.id_prodi = d.id_prodi where pn.status_rekomen=1 and d.id_prodi = #{id_prodi}")
	List<PendaftarModel> selectAllPendaftarRec(@Param("id_prodi") int id_prodi);

	@Select("SELECT * FROM PENDAFTAR"
			+ " JOIN PENYELEKSIAN ON pendaftar.no_daftar = penyeleksian.no_daftar"
			+ " JOIN JALUR_MASUK ON penyeleksian.id_jalur = jalur_masuk.id_jalur WHERE jalur_masuk.id_jalur=4 AND no_id=#{no_id}")
	PendaftarModel selectPPKB(@Param("no_id") String no_id);
	
//	@Select("select nama_id, no_id, jurusan, penyeleksian.status as status from pendaftar"
//			+ " join PENYELEKSIAN on pendaftar.no_daftar = penyeleksian.no_daftar"
//			+ " join JALUR_MASUK on penyeleksian.id_jalur = jalur_masuk.id_jalur AND penyeleksian.status=1")
//	@Results(value = {
//			@Result(property = "nama_id", column = "nama_id"),
//			@Result(property = "no_id", column ="no_id"),
//			@Result(property = "jurusan", column = "jurusan")})
//	List<PendaftarModel> selectTerverifikasi();
	
//	@Select("select nama_id, no_id, jurusan, penyeleksian.status as status from pendaftar"
//			+ " join PENYELEKSIAN on pendaftar.no_daftar = penyeleksian.no_daftar"
//			+ " join JALUR_MASUK on penyeleksian.id_jalur = jalur_masuk.id_jalur AND penyeleksian.status=0")
//	@Results(value = {
//			@Result(property = "nama_id", column = "nama_id"),
//			@Result(property = "no_id", column ="no_id"),
//			@Result(property = "jurusan", column = "jurusan")})
//	List<PendaftarModel> selectTakTerverifikasi();
	
	@Select("SELECT * FROM CALON_MAHASISWA WHERE no_daftar=#{no_daftar}")
	PendaftarModel selectPendaftarLulus(@Param("no_daftar") int no_daftar);
	
	@Select("select p.* from pendaftar p, penyeleksian pn, prodi_tersedia pr, daftar_pilihan d where pn.no_daftar=p.no_daftar and pn.no_daftar=d.no_daftar and "
			+ "pr.id_prodi = d.id_prodi and pn.status=0 and d.id_prodi = #{id_prodi} and pn.id_jalur=#{id_jalur}")
	List<PendaftarModel> selectAllPendaftarSemua(@Param("id_prodi")int id_prodi, @Param("id_jalur")int id_jalur);
	
	@Select("select * from pendaftar where no_daftar=#{no_daftar}")
	PendaftarModel selectPendaftar3(@Param("no_daftar") int no_daftar);

	@Select("SELECT NAMA_ID FROM PENDAFTAR WHERE no_daftar=#{no_daftar}")
	PendaftarModel selectNama(@Param("no_daftar") int no_daftar);
	
}
