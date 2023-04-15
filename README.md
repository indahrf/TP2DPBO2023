# TP2DPBO2023

Saya Indah Resti Fauzi NIM 2103507 mengerjakan Tugas Praktikum 2 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

# Desain Program

![tp2 drawio](https://user-images.githubusercontent.com/99266430/232198203-e7c4e617-a3c7-44d2-9f8c-72ed692ec836.png)

# Alur Program

![image](https://user-images.githubusercontent.com/99266430/232198353-2e418da2-b83d-44a7-af27-eb8d65395c9b.png)

1. Program dihubungkan dengan database pada file config.java 
2. Saat program dijalankan, program akan masuk ke form login dimana ada tombol regis dan submit login
3. Ketika memilih tombol register, maka form login akan tertutup dan form register terbuka
4. Ketika memilih login dengan memasukkan data valid maka akan menampilkan halaman utama berisi daftar playlist akun yang sedang login
5. Daftar playlist dipanggil dengan menggunakan foreach untuk menampilkan card sejumlah banyaknya data pada playlist milik akun yang login

# Dokumentasi

1. Login
  - Hanya data yang valid/terdaftar pada database yang bisa login
  - Tombol register untuk melakukan pendaftaran akun
  - Tombol login untuk login ke laman utama
  
![login](https://user-images.githubusercontent.com/99266430/232199103-ea447cf8-4548-4fd9-820e-302e7acc6532.png)


2. Register
  - Data tidak boleh kosong dan sama seperti data yang telah ada
  - Tombol register untuk konfirmasi pendaftaran
  - Tombol cancel untuk kembali ke form login
  
![register](https://user-images.githubusercontent.com/99266430/232199158-be566f8c-139e-4bc0-a988-7cab434beebf.png)


3. Laman Utama
  - kanan : Form untuk menambahkan data baru, data yang diinputkan merupakan data milik id_akun yang sedang login
  - kiri  : Daftar playlist lagu milik akun yang sedang login
  
![main](https://user-images.githubusercontent.com/99266430/232199279-2485cc0f-5f0b-4e87-ba27-291eb6245826.png)


4. Add

![add (1)](https://user-images.githubusercontent.com/99266430/232199294-ea10871a-0d1e-4d82-b004-c5b387781a4f.png)

![add (2)](https://user-images.githubusercontent.com/99266430/232199305-7c472326-4cb0-4052-b438-b0ddff3b4bf5.png)

![add (3)](https://user-images.githubusercontent.com/99266430/232199426-89b66ccc-2b85-493e-9f38-bbb251ab6c1b.png)


5. Update

![update (1)](https://user-images.githubusercontent.com/99266430/232199443-d3b827c0-bfe3-494d-9493-12751e96fd44.png)

![update (2)](https://user-images.githubusercontent.com/99266430/232199448-8dd6d483-955f-4898-a155-f718dd6e4839.png)

![update (3)](https://user-images.githubusercontent.com/99266430/232199454-9d6d265d-a8dc-43e9-bf61-2346ded97ac8.png)


6. Delete

![delete (1)](https://user-images.githubusercontent.com/99266430/232199468-cfd55c7c-1c0b-4792-90e8-d8dc485bf3e7.png)

![delete (2)](https://user-images.githubusercontent.com/99266430/232199476-83f8e770-e73f-4804-9de2-ace2cafcbb88.png)

![delete (3)](https://user-images.githubusercontent.com/99266430/232199481-20de46d5-7eed-4bea-bf1f-4ccc88c2f524.png)
