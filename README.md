# PresensiRestFullAPI

Web Service

Registrasi siswa baru 
method:POST http://localhost:5060/api/student/register
{
    "idProdi":"1",
    "name":"Faiz Ahnaf Eka Putra",
    "password":"Ahnaffaiz",
    "gender":"Laki-laki",
}

Login (Mencari data Siswa Berdasarkan username dan password)
method:POST http://localhost:5060/api/student/login
{
    "name":"Faiz Ahnaf Eka Putra",
    "password":"Ahnaffaiz"
}

Presensi Masuk (Mencatat Presensi Siswa Berdasarkan Id)
method:GET http://localhost:5060/api/presensi/{idStudent}

Menampilkan Seluruh Presensi
method:GET http://localhost:5060/api/presensi/showall

-------------------------------------------------------------------------------
Fitur Tambahan

Menambahkan Alamat Siswa
method:POST http://localhost:5060/api/student/address/{idStudent}
{
    "alamat":"Kentingan, Jebres, Surakarta"
}

Menampilkan Alamat Siswa berdasarkan idStudent
method:GET http://localhost:5060/api/student/address/{idStudent}

Menambahkan Email Siswa
method:POST http://localhost:5060/api/student/mail/{idStudent}
{
    "email":"faizahnaf@mail.com"
}

Menampilkan Email Siswa berdasarkan idStudent
method:GET http://localhost:5060/api/student/mail/{idStudent}

Menambahkan Prodi
method:POST http://localhost:5060/api/prodi/add-prodi
{
    "prodi":"Pendidikan Bahasa Inggris"
}

Menampilkan Semua Prodi
method:GET http::/localhost:5060/api/prodi/showall


