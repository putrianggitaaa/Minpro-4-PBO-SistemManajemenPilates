# Sistem Manajemen Pilates - Geets Pilates Studio
**Putri Anggita Melasari | 2509116010**

## Deskripsi Program
Sistem Manajemen Pilates Geets Pilates Studio merupakan sebuah program yang dirancang untuk membantu proses pengelolaan data pada sebuah studio Pilates secara sederhana.
Program ini menyediakan beberapa menu yang dapat digunakan untuk mengelola informasi terkait Member, Instruktur, Jenis Kelas, dan Data Kelas Pilates. 
Sistem ini dapat membantu pengelola untuk memanajemen proses bisnis yang terdapat dalam Geets Pilates Studio.

## Struktur Packages
Program Sistem Manajemen Pilates menerapkan konsep MVC (Model, View, Controller) dengan membagi struktur program ke dalam beberapa package, yaitu model, view, dan controller. 
Pembagian ini digunakan untuk memisahkan pengelolaan data, proses pengolahan data, serta bagian utama yang menjalankan program. 

<img width="406" height="743" alt="image" src="https://github.com/user-attachments/assets/29937c05-e21c-47d1-8611-ae04c7db6c1d" />

Berikut adalah penjelasan dari masing-masing package yang ada didalam packages tersebut:

### 1. Package Config
Package Config berfungsi untuk menyimpan konfigurasi koneksi ke database MySQL.

### 2. Package Controller
Package controller berfungsi untuk mengatur alur proses dan logika interaksi antara bagian view, model, dan service. Controller menerima pilihan atau input dari pengguna melalui View, kemudian menjalankan proses sesuai dengan fitur yang dipilih.

### 3. Package Main
Package main merupakan bagian yang digunakan sebagai titik awal atau entry point dari program. 

### 4. Package Model
Package model berisi class yang digunakan untuk merepresentasikan objek dan data utama dalam sistem manajemen Pilates.

### 5. Package Service
Package service berisi class yang menangani proses pendukung dan validasi yang digunakan oleh sistem.

### 6. Package View
Package view bertanggung jawab terhadap tampilan dan interaksi langsung dengan pengguna. View digunakan untuk menampilkan menu, informasi data, serta meminta input dari pengguna.

## Alur Program
Alur program dimulai ketika pengguna menjalankan program melalui class Pilates.java sebagai class utama. Setelah program dijalankan, sistem akan menampilkan halaman utama  yang berisi beberapa pilihan menu.
Pengguna dapat memilih menu dengan menginput angka sesuai dengan pilihan yang tersedia. Sistem kemudian menggunakan percabangan switch-case untuk menentukan proses yang akan dijalankan.

Jika pengguna memilih menu Member, sistem akan mengarahkan pengguna ke proses lihat, tambah, update atau hapus data member. Jika memilih Instruktur, sistem akan mengarahkan pengguna ke proses lihat, tambah, update atau hapus data instruktur. Jika memilih Jenis Kelas, sistem akan mengarahkan pengguna ke proses lihat, tambah, update atau hapus data Jenis Kelas. Apabila pengguna memilih menu daftar kelas, maka akan diarahkan ke lihat daftar kelas yang sudah ada, menambahkan daftar kelas baru, menghapus daftar kelas yang sudah ada, dan melakukan update pada data daftar kelas. 

## Penerapan Encapsulation
Konsep encapsulation diterapkan pada class Member, Instruktur, JenisKelas, JenisKelasPrivate, JenisKelasPublik, dan KelasPilates dengan menjadikan atribut-atribut di dalamnya sebagai private. Atribut tersebut tidak dapat diakses secara langsung dari class lain, sehingga akses data dilakukan melalui getter dan setter yang telah disediakan. Selain itu, class Service juga menerapkan encapsulation pada atribut seperti daftarMember, daftarInstruktur, daftarJenisKelas, dan daftarKelas, sedangkan class InputValidator menerapkannya pada atribut scanner. Penggunaan encapsulation berfungsi untuk melindungi dan membatasi akses langsung terhadap data, sehingga perubahan maupun pengambilan data harus dilakukan melalui method yang telah ditentukan dan data menjadi lebih terkontrol.  

## Penerapan Inheritance
Inheritance dalam program ini diterapkan dengan membuat class JenisKelas.java yang bertindak sebagai Superclass dan class JenisKelasPrivate.java serta JenisKelasPublik.java yang bertindak sebagai Subclass. Kedua class yang bertindak sebagai Subclass tersebut mewarisi atribut dari Superclass nya, yaitu JenisKelas.java. Pada JenisKelasPrivate.java terdapat tambahan atribut khusus yaitu jenisSesi dan untuk JenisKelasPublik.java terdapat tambahan atribut khusus yaitu kapasitas. Pada masing-masing Subclass, diterapkan keyword 'super' untuk mengakses atribut dari Superclass nya. Selain itu, terdapat penerapan keyword 'final' pada atribut kapasitas dibagian InputValidator yang bertujuan untuk membatasi modifikasi pada atribut kapasitas sehingga pengguna dapat memasukkan kapasitas maksimal 25.

## Penerapan Polymorphism
Polymorphism dalam program ini diterapkan melalui method overriding pada class JenisKelasPrivate dan JenisKelasPublik yang merupakan Subclass dari JenisKelas. Kedua Subclass tersebut memiliki method yang sama dengan Superclass, tetapi dapat memberikan implementasi yang berbeda sesuai dengan karakteristik masing-masing jenis kelas. Dengan demikian, ketika method tersebut dipanggil melalui objek JenisKelas, program dapat menjalankan implementasi method sesuai dengan jenis objek yang digunakan. Penerapan polymorphism ini membuat program lebih fleksibel karena satu method dapat memiliki perilaku yang berbeda pada masing-masing Subclass.

Polymorphism dalam program ini juga diterapkan melalui method overloading pada class Service, yaitu pada method lihatInstruktur(String spesialisasi) yang digunakan untuk menampilkan data instruktur berdasarkan spesialisasi tertentu. Dengan adanya perbedaan parameter, method lihatInstruktur() dapat digunakan untuk menampilkan data instruktur secara umum maupun berdasarkan spesialisasi yang dipilih. Penerapan method overloading ini membuat program lebih fleksibel karena satu nama method dapat digunakan untuk menangani kebutuhan yang berbeda sesuai dengan parameter yang diberikan.

## Penerapan Abstraction
Abstraction dalam program ini diterapkan melalui abstract class JenisKelas dan abstract method tampilkanInfo(). Method tersebut menjadi aturan yang harus diimplementasikan oleh subclass seperti JenisKelasPrivate dan JenisKelasPublik. Dengan demikian, setiap jenis kelas dapat menampilkan informasi sesuai karakteristiknya masing-masing tanpa perlu mengetahui detail implementasinya.

## Penerapan Interface
Interface dalam program ini diterapkan melalui interface `CetakStruk` yang memiliki method `cetakStruk()`. Interface ini berfungsi sebagai kontrak yang menentukan bahwa class yang mengimplementasikannya harus memiliki method `cetakStruk()`. Pada program, struk akan dicetak setiap kali selesai melakukan pendaftaran kelas dan setelah melakukan update status kelas. Dengan demikian, interface `CetakStruk` membantu membuat proses pencetakan struk lebih terstruktur dan memastikan informasi dari setiap proses dapat ditampilkan kepada pengguna.
Program akan terus berjalan dan menampilkan kembali menu utama selama pengguna belum memilih menu Keluar. Dengan demikian, pengguna dapat melakukan beberapa proses pengelolaan data dalam satu kali menjalankan program.

## Penerapan JDBC
JDBC dalam program ini diterapkan untuk menghubungkan program dengan database MySQL. Penerapannya terdapat pada package `config`, melalui class `Koneksi.java` untuk mengatur koneksi database, serta package `model` yang berisi class DAO, yaitu `MemberDAO`, `InstrukturDAO`, `JenisKelasDAO`, dan `KelasPilatesDAO` untuk mengelola data masing-masing entitas.

Program ini menggunakan pengimplementasian `Connection` untuk mengakses database, `PreparedStatement` untuk menjalankan query SQL dengan parameter, dan `ResultSet` untuk membaca hasil query. JDBC mendukung operasi CRUD sehingga data member, instruktur, jenis kelas, dan sesi kelas dapat ditambahkan, ditampilkan, diperbarui, dan dihapus melaluiprogram serta tersimpan dalam database MySQL. Dengan adanya JDBC kita tidak perlu lagi menyimpan data dalam bentuk ArrayList karena penyimpanan data langsung ke database dan data tersimpan secara permanen bahkan ketika program telah berhenti.

## Dokumentasi Program 
Adapun dokumentasi dari alur program yaitu sebagai berikut:

### Tampilan Menu Utama

<img width="523" height="317" alt="image" src="https://github.com/user-attachments/assets/3fe1ba04-dba1-48e5-8fae-3b3b1811be6d" />

Ketika program dijalankan, pengguna akan diberikan beberapa pilihan menu yang dapat digunakan untuk mengelola data. Terdapat menu member yang berfungsi untuk mengelola data member, menu Instruktur yang digunakan untuk mengelola data instruktur, menu jenis kelas yang digunakan untuk mengelola jenis kelas yang tersedia, serta menu pendaftaran kelas yang digunakan untuk mengelola daftar kelas yang akan dilaksanakan di studio pilates ini.

### Menu Member

<img width="421" height="295" alt="image" src="https://github.com/user-attachments/assets/8ddb1ed3-3513-419d-8d63-6fa77b976317" />


Menu member berisi 5 sub menu yang fungsinya sebagai berikut:

* **1. Tambah Member**

<img width="510" height="532" alt="image" src="https://github.com/user-attachments/assets/ba92b18b-a6ab-4cb3-8da9-d509e36cffff" />



Pada sub menu ini, pengguna dapat menambahkan member baru yang akan bergabung untuk mengikuti kelas di studio dengan memasukkan ID member, nama member, nomor telepon, usia dan jenis kelamin member tersebut.

* **2. Lihat Member**

<img width="492" height="468" alt="image" src="https://github.com/user-attachments/assets/72dbd33e-47cc-4230-88b2-18e4f4c4d818" />


Pada sub menu ini, pengguna dapat melihat daftar member yang telah terdaftar pada sistem.

* **3. Update Status Member**

<img width="647" height="737" alt="image" src="https://github.com/user-attachments/assets/4775d0eb-12ff-46df-af46-279e5a33918b" />

Pada sub menu ini, pengguna dapat mengubah status keaktifan dari member yang terdaftar dengan kategori Aktif dan Nonaktif.

* **4. Hapus Member**

<img width="522" height="617" alt="image" src="https://github.com/user-attachments/assets/94165891-f9ea-45e5-880f-c870bce2b05e" />

Pada sub menu ini, pengguna dapat menghapus member yang terdaftar dengan syarat member tersebut tidak terdapat dalam daftar kelas yang sedang berjalan.

* **5. Kembali**

<img width="516" height="402" alt="image" src="https://github.com/user-attachments/assets/20313494-8691-4a67-82ae-ccf7d367ba7c" />


Pada sub menu ini, pengguna dapat kembali ke menu utama program.

### Menu Instruktur

<img width="496" height="396" alt="image" src="https://github.com/user-attachments/assets/c63a9ac2-f03e-4e1d-835c-7bdbd0a2f565" />

Menu instruktur berisi 6 sub menu yang fungsinya sebagai berikut:

* **1. Tambah Instruktur**

<img width="615" height="525" alt="image" src="https://github.com/user-attachments/assets/6245ad2c-5de6-4a30-9b68-db51395bfcad" />


Pada sub menu ini, pengguna dapat menambahkan instruktur baru yang akan bergabung untuk memandu kelas di studio dengan memasukkan ID instruktur, nama instruktur, spesialisasi, nomor telepon, dan jenis kelamin instruktur tersebut.

* **2. Lihat Instruktur**

<img width="498" height="588" alt="image" src="https://github.com/user-attachments/assets/80aa6cad-2e05-499c-a92a-a890a0ef53af" />

Pada sub menu ini, pengguna dapat melihat daftar instruktur yang telah terdaftar pada sistem.

* **3. Lihat Instruktur Berdasarkan Spesialisasi**

<img width="510" height="407" alt="image" src="https://github.com/user-attachments/assets/b8e8288d-e437-48f9-b488-f64c460d2765" />

Pada sub menu ini, pengguna dapat melihat instruktur berdasarkan spesialisasi tertentu yang diinginkan. 

* **4. Update Status Instruktur**

<img width="715" height="797" alt="image" src="https://github.com/user-attachments/assets/8838a782-d5ce-4e6b-ac4d-84833e44e3ab" />

Pada sub menu ini, pengguna dapat mengubah status keaktifan dari Instruktur yang terdaftar dengan kategori Aktif dan Nonaktif.

* **5. Hapus Instruktur**
  
<img width="575" height="587" alt="image" src="https://github.com/user-attachments/assets/4604ae97-4a61-4b1d-b48c-f548cad73fc4" />

Pada sub menu ini, pengguna dapat menghapus instruktur yang terdaftar dengan syarat instruktur tersebut tidak terdapat dalam daftar kelas yang sedang berjalan.

* **6. Kembali**

<img width="525" height="390" alt="image" src="https://github.com/user-attachments/assets/7a0b29dc-14c3-4401-af66-0af97b5d7446" />

Pada sub menu ini, pengguna dapat kembali ke menu utama program.

### Menu Jenis Kelas

<img width="472" height="361" alt="image" src="https://github.com/user-attachments/assets/15ba83c4-6e22-426a-8f77-df61577c0ae4" />

Menu jenis kelas berisi 5 sub menu yang fungsinya sebagai berikut:

* **1. Tambah Jenis Kelas**
  
<img width="532" height="582" alt="image" src="https://github.com/user-attachments/assets/8a563b44-4162-4811-9b5f-5965ea5df9d9" />

Pada sub menu ini, pengguna dapat menambahkan jenis kelas baru yang akan diadakan di studio dengan memasukkan ID jenis, nama pilates, level, durasi, dan kapasitas dari jenis kelas tersebut.

* **2. Lihat Jenis Kelas**

<img width="498" height="746" alt="image" src="https://github.com/user-attachments/assets/3dc4108c-4fa6-4437-8694-465b22b18b60" />


Pada sub menu ini, pengguna dapat melihat daftar jenis kelas yang telah terdaftar pada sistem.

* **3. Update Status Jenis Kelas**

<img width="732" height="301" alt="image" src="https://github.com/user-attachments/assets/bc9c4880-4ded-4891-a7a3-e2d2d24fc7ba" />

Pada sub menu ini, pengguna dapat mengubah status keaktifan dari jenis kelas yang terdaftar dengan kategori Tersedia dan Tidak Tersedia.

* **4. Hapus Jenis Kelas**

<img width="563" height="728" alt="image" src="https://github.com/user-attachments/assets/ff688352-967b-420b-9b94-6a84b0b114b8" />

Pada sub menu ini, pengguna dapat menghapus jenis kelas yang terdaftar dengan syarat jenis kelas tersebut tidak terdapat dalam daftar kelas yang sedang berjalan.

* **5. Kembali**

<img width="530" height="397" alt="image" src="https://github.com/user-attachments/assets/66c632c3-a1a9-4e89-83d2-b447c772ccf9" />

Pada sub menu ini, pengguna dapat kembali ke menu utama program.

### Menu Daftar Kelas

<img width="495" height="280" alt="image" src="https://github.com/user-attachments/assets/bf365e87-171b-42b5-92d8-4b6b65db162c" />

Menu pendaftaran kelas berisi 5 sub menu yang fungsinya sebagai berikut:

* **1. Daftar Kelas**

<img width="520" height="511" alt="image" src="https://github.com/user-attachments/assets/ea2ea6c1-28e4-43a2-a959-38a620411b28" />

Pada sub menu ini, pengguna dapat mendaftarkan member, instruktur, dan jenis kelas kedalams sebuah sesi kelas. Setelah pendaftaran berhasil, program akan menampilkan output berupa struk sebagai perwujudan dari interface CetakStruk()

* **2. Lihat Pendaftar Kelas**

<img width="527" height="591" alt="image" src="https://github.com/user-attachments/assets/f29abcb4-99e2-4b59-b8fe-936cff57e697" />

Pada sub menu ini, pengguna dapat melihat daftar kelas yang telah terdaftar pada sistem dan siap untuk dilaksanakan pada studio. Data ini berisi identitas member yang melaksanakan kelas, instruktur yang memandu kelas, jenis kelas yang dilaksanakan dan waktunya.

* **3. Update Kelas**

<img width="512" height="297" alt="image" src="https://github.com/user-attachments/assets/68860f4a-15ab-40e7-bcec-270a0cf77127" />

Pada sub menu ini, sistem akan mengarahkan pengguna untuk melakukan update terhadap status kelas yang ada. Update bisa berupa Terjadwal, Selesai, atau Batal. Sub Menu ini berguna untuk memudahkan pengelola dalam menandai status kelas yang telah terdaftar.

Pada sub menu ini, sistem akan mengarahkan pengguna untuk menginput ID kelas yang akan dihapus. Selanjutnya, sistem akan menghapus kelas sesuai dengan ID yang di input oleh pengguna. Sub menu ini dapat digunakan apabila sesi kelas telah selesai dilaksanakan dan member tidak ingin memperpanjang sesi kelas nya kembali.

* **4. Hapus Kelas**

<img width="557" height="522" alt="image" src="https://github.com/user-attachments/assets/f7247310-6943-4a28-bdfe-5905e16bcc73" />

Pada sub menu ini, sistem akan mengarahkan pengguna untuk menginput ID kelas yang akan dihapus. Selanjutnya, sistem akan menghapus kelas sesuai dengan ID yang di input oleh pengguna. Sub menu ini dapat digunakan apabila sesi kelas telah selesai dilaksanakan dan member tidak ingin memperpanjang sesi kelas nya kembali.

* **5. Kembali**
  
<img width="515" height="305" alt="image" src="https://github.com/user-attachments/assets/9301ecec-64de-4fed-a4d4-2997e7d864c7" />

Pada sub menu ini, pengguna dapat kembali ke menu utama program.
  
### Menu Keluar dari Program

<img width="507" height="387" alt="image" src="https://github.com/user-attachments/assets/5d1b1041-55c8-4139-97ec-340e62257c34" />

