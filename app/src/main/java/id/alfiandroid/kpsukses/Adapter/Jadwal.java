package id.alfiandroid.kpsukses.Adapter;

public class Jadwal {

    private String nama_kelas;
    private String waktu_pengajaran;

    public Jadwal(){}

    public Jadwal(String nama_kelas, String waktu_pengajaran) {
        this.setNama_kelas(nama_kelas);
        this.setWaktu_pengajaran(waktu_pengajaran);
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public String getWaktu_pengajaran() {
        return waktu_pengajaran;
    }

    public void setWaktu_pengajaran(String waktu_pengajaran) {
        this.waktu_pengajaran = waktu_pengajaran;
    }
}
