//nama: Izzat Nazhiefa
//NIM: F1D02310114
//Mobile B

fun inputNilai(): Double {
    while (true) {
        val input = readln().toDoubleOrNull()

        if (input != null && input in 0.0..100.0) {
            return input
        } else {
            println("Masukkan angka 0 - 100.")
        }
    }
}

fun main (){
    print("Masukka Nama Mhasiswa: ")
    val namaMhs = readLine()
    print("Masukkan Nilai UTS (0-100): ")
    val nilaiUts = inputNilai()
    print("Masukkan Nilai UAS (0-100): ")
    val nilaiUas = inputNilai()
    print("Masukkan Nilai Tugas (0-100): ")
    val nilaiTugas = inputNilai()
    print("\nHasil Penilaian\n")
    print("Nama: $namaMhs " +
            "\nNilai UTS: $nilaiUts " +
            "\nNilai UAS: $nilaiUas " +
            "\nNilai Tugas: $nilaiTugas")
    print(" ")
    val nilaiAkhir = (nilaiUts * 0.3) + (nilaiUas * 0.4) + (nilaiTugas * 0.3)

    val grade = when (nilaiAkhir){
        in 85.0..100.0 -> "A"
        in 80.0..84.9 -> "B+"
        in 75.0..79.9 -> "B"
        in 70.0..74.9 -> "C+"
        in 65.0..69.9 -> "C"
        else -> "D"
    }

    val keterangan = when (grade){
        "A", "B+" -> "Sangat Baik"
        "B" -> "Baik"
        "C+", "C" -> "Cukup"
        else -> "Kurang"
    }

    val status = if (grade == "A" || grade == "B" || grade == "B+" || grade == "C+" || grade == "C") {
        "Lulus"
    }else{
        "tidak lulus"
    }
    print(" ")
    print("\nNilai Akhir: $nilaiAkhir " +
            "\nGrade: $grade " +
            "\nKeterangan: $keterangan " +
            "\nStatus: $status " +
            "\nSelamat! Anda dinyatakan $status")
    }
