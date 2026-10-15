package model;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Consumer;

public class InstrukturDAO {

    public void forEach(Consumer<Instruktur> aksi) throws SQLException {
        String sql = "SELECT * FROM instruktur ORDER BY id_instruktur";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) aksi.accept(bacaInstruktur(rs));
        }
    }

    private Instruktur bacaInstruktur(ResultSet rs) throws SQLException {
        return new Instruktur(
            rs.getInt("id_instruktur"), rs.getString("nama"),
            rs.getString("spesialisasi"), rs.getString("no_telepon"),
            rs.getString("jenis_kelamin"), rs.getString("domisili"),
            rs.getString("status")
        );
    }

    public Instruktur findById(int id) throws SQLException {
        String sql = "SELECT * FROM instruktur WHERE id_instruktur = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return bacaInstruktur(rs);
            }
        }
        return null;
    }

    public boolean existsById(int id) throws SQLException {
        String sql = "SELECT 1 FROM instruktur WHERE id_instruktur = ? LIMIT 1";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        }
    }

    public boolean isUsedInKelas(int id) throws SQLException {
        String sql = "SELECT 1 FROM kelas_pilates WHERE id_instruktur = ? LIMIT 1";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        }
    }

    public boolean insert(Instruktur instruktur) throws SQLException {
        String sql = "INSERT INTO instruktur (id_instruktur, nama, spesialisasi, no_telepon, jenis_kelamin, domisili, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, instruktur.getIdInstruktur());
            ps.setString(2, instruktur.getNamaInstruktur());
            ps.setString(3, instruktur.getSpesialisasi());
            ps.setString(4, instruktur.getNoTelepon());
            ps.setString(5, instruktur.getJenisKelamin());
            ps.setString(6, instruktur.getDomisili());
            ps.setString(7, instruktur.getStatus());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean updateStatus(int id, String status) throws SQLException {
        String sql = "UPDATE instruktur SET status = ? WHERE id_instruktur = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM instruktur WHERE id_instruktur = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
