# Survei Harga Konsumen

Proyek ini adalah aplikasi untuk melakukan survei harga konsumen, di mana operator dan pencacah dapat melakukan berbagai tindakan terkait dengan pendaftaran, login, pengelolaan data responden, kualitas barang, serta pengisian kuisioner harga barang.

## Identitas Pembuat Proyek

- **Nama**: Muhammad Hilma Raffandy
- **Kampus**: Politeknik Statistika STIS
- **Kelas**: 3SI2
- **NIM**: 222212755

## Proses Bisnis

### 1. **Register**
- Pengguna akan mendaftar akun sesuai dengan perannya.
  - **Admin**: Mendaftar melalui endpoint admin.
  - **User**: Mendaftar melalui endpoint user.

### 2. **Login**
- Pengguna dapat login menggunakan email dan password yang telah didaftarkan sebelumnya.
- Setelah berhasil login, pengguna akan mendapatkan **Access Token** dalam bentuk bearer token yang wajib disimpan untuk melakukan autentikasi di endpoint lainnya.

### 3. **View Akun**
- Pengguna yang telah login dapat melihat informasi akunnya, termasuk nama, email, dan peran, dengan mengakses endpoint **"view-user"** menggunakan method **GET**.

### 4. **Update Profil dan Ganti Password**
- Pengguna yang telah login dapat memperbarui profil dan mengganti password.
  - **Update Profil**: Mengakses endpoint **"update-profil-user"**.
  - **Ganti Password**: Mengakses endpoint **"update-password"**, memasukkan password lama dan password baru menggunakan method **PATCH**.
- Sistem akan memverifikasi data dan memperbarui informasi jika valid.

### 5. **Hapus Akun**
- Pengguna yang telah login dan ingin menghapus akunnya dapat mengakses endpoint **"delete-user"** dengan method **DELETE**.
- Sistem akan memverifikasi identitas pengguna dan menghapus akun jika data valid.

---

## Fitur Pencacahan

### 1. **Tambah Responden**
- **Operator** akan mengakses endpoint **"responden"** untuk menambahkan data responden ke dalam survei harga konsumen.
- Data yang dimasukkan: nama, alamat, pasar, dan kode responden.
- Data responden akan diverifikasi dan ditambahkan ke survei.

### 2. **Tambah Kualitas**
- **Operator** akan mengakses endpoint **"kualitas"** untuk menambahkan kualitas barang ke dalam survei harga konsumen.
- Data yang dimasukkan: nama barang dan atribut kualitas.
- Data kualitas akan diverifikasi dan ditambahkan ke survei.

### 3. **Pengisian Kuisioner (HK 1.1 sampai HK 2.2)**
- **Pencacah** akan mengisi kuisioner terkait harga barang sesuai dengan kategori **HK 1.1 sampai HK 2.2**.
- Pencacah akan mengakses endpoint khusus untuk mengisi data harga barang yang berlaku pada survei.
- Data harga yang dimasukkan akan diverifikasi dan disimpan sesuai dengan kategori yang relevan.

---
## Dokumentasi API

### **EndPoints**

#### **hk-1_1-entity-controller**
- **GET** `/hk1_1s`: Mendapatkan data survei harga hk1_1
- **POST** `/hk1_1s`: Menambahkan data survei harga hk1_1
- **GET** `/hk1_1s/{id}`: Mendapatkan data berdasarkan id
- **PUT** `/hk1_1s/{id}`: Memperbarui data berdasarkan id
- **DELETE** `/hk1_1s/{id}`: Menghapus data berdasarkan id
- **PATCH** `/hk1_1s/{id}`: Memperbarui data sebagian berdasarkan id

#### **hk-1_1-search-controller**
- **GET** `/hk1_1s/search/findByKomoditas`: Mencari berdasarkan komoditas
- **GET** `/hk1_1s/search/findByResponden`: Mencari berdasarkan responden

#### **hk-2_1-entity-controller**
- **GET** `/hk2_1s`: Mendapatkan data survei harga hk2_1
- **POST** `/hk2_1s`: Menambahkan data survei harga hk2_1
- **GET** `/hk2_1s/{id}`: Mendapatkan data berdasarkan id
- **PUT** `/hk2_1s/{id}`: Memperbarui data berdasarkan id
- **DELETE** `/hk2_1s/{id}`: Menghapus data berdasarkan id
- **PATCH** `/hk2_1s/{id}`: Memperbarui data sebagian berdasarkan id

#### **hk-2_1-search-controller**
- **GET** `/hk2_1s/search/findByKomoditas`: Mencari berdasarkan komoditas
- **GET** `/hk2_1s/search/findByResponden`: Mencari berdasarkan responden

#### **Tabel ERD**

Berikut adalah struktur dari beberapa tabel yang digunakan dalam proyek ini:

- **Tabel hk1_1**: Menyimpan data survei harga konsumen jenis hk1_1 yang berisi kolom-kolom seperti id, kode_kualitas, komoditas, kualitas, responden, harga sebelum, dan harga sekarang.
- **Tabel hk1_2**: Menyimpan data survei harga konsumen jenis hk1_2 yang berisi kolom-kolom serupa dengan hk1_1.
- **Tabel hk2_1**: Menyimpan data survei harga konsumen jenis hk2_1 yang berisi kolom-kolom seperti id, kode_kualitas, komoditas, kualitas, responden, harga sebelum, dan harga sekarang.
- **Tabel hk2_2**: Menyimpan data survei harga konsumen jenis hk2_2 yang berisi kolom-kolom serupa dengan hk2_1.
- **Tabel user**: Menyimpan informasi pengguna yang mengakses sistem dengan relasi many-to-many untuk menentukan hak akses pengguna.
- **Tabel role**: Menyimpan informasi tentang peran atau hak akses pengguna.
- **Tabel kualitas**: Menyimpan daftar kualitas atau atribut yang digunakan dalam survei harga konsumen.
- **Tabel responden**: Menyimpan informasi tentang responden yang terlibat dalam survei.
