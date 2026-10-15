package model;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.function.Consumer;

public class KelasPilatesDAO {

    public void forEach(Consumer<KelasPilates> aksi) throws SQLException {
        String sql = "SELECT * FROM kelas_pilates ORDER BY id_kelas";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) aksi.accept(bacaKelas(rs));
        }
    }

    private KelasPilates bacaKelas(ResultSet rs) throws SQLException {
        return new KelasPilates(
            rs.getInt("id_kelas"), rs.getInt("id_member"),
            rs.getInt("id_instruktur"), rs.getInt("id_jenis"),
            rs.getDate("tanggal").toString(), rs.getTimestamp("waktu").toString(),
            rs.getString("status")
        );
    }

    public KelasPilates findById(int idKelas) throws SQLException {
        String sql = "SELECT * FROM kelas_pilates WHERE id_kelas = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idKelas);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return bacaKelas(rs);
            }
        }
        return null;
    }

    public boolean existsById(int idKelas) throws SQLException {
        String sql = "SELECT 1 FROM kelas_pilates WHERE id_kelas = ? LIMIT 1";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idKelas);
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        }
    }

    public boolean insert(KelasPilates kelas) throws SQLException {
        String sql = "INSERT INTO kelas_pilates (id_kelas, id_member, id_instruktur, id_jenis, tanggal, waktu, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, kelas.getIdKelas());
            ps.setInt(2, kelas.getIdMember());
            ps.setInt(3, kelas.getIdInstruktur());
            ps.setInt(4, kelas.getIdJenis());
            ps.setDate(5, Date.valueOf(kelas.getTanggal()));
            ps.setTimestamp(6, Timestamp.valueOf(kelas.getWaktu()));
            ps.setString(7, kelas.getStatus());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean update(KelasPilates kelas) throws SQLException {
        String sql = "UPDATE kelas_pilates SET id_member = ?, id_instruktur = ?, id_jenis = ?, tanggal = ?, waktu = ?, status = ? WHERE id_kelas = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, kelas.getIdMember());
            ps.setInt(2, kelas.getIdInstruktur());
            ps.setInt(3, kelas.getIdJenis());
            ps.setDate(4, Date.valueOf(kelas.getTanggal()));
            ps.setTimestamp(5, Timestamp.valueOf(kelas.getWaktu()));
            ps.setString(6, kelas.getStatus());
            ps.setInt(7, kelas.getIdKelas());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean updateStatus(int idKelas, String status) throws SQLException {
        String sql = "UPDATE kelas_pilates SET status = ? WHERE id_kelas = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, idKelas);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int idKelas) throws SQLException {
        String sql = "DELETE FROM kelas_pilates WHERE id_kelas = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idKelas);
            return ps.executeUpdate() > 0;
        }
    }
}
