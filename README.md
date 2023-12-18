# App "Ganhe na Mega"

Este é um aplicativo simples desenvolvido em Kotlin no Android Studio para gerar números aleatórios para a Mega-Sena.

## Funcionalidades

- Geração de números aleatórios para a Mega-Sena dentro do intervalo desejado (entre 6 e 15 números).
- Interface simples e intuitiva.

## Como usar

1. Clone o repositório do projeto.
2. Abra o projeto no Android Studio.
3. Execute o aplicativo em um emulador ou dispositivo Android.

## Exemplo de Código

Aqui está um trecho de código que mostra como os números são gerados:

```kotlin
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class SuaAtividade : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seu_layout)

        val btnGerarNumeros = findViewById<Button>(R.id.btnGerarNumeros)

        btnGerarNumeros.setOnClickListener {
            gerarNumeros()
        }
    }

    private fun gerarNumeros() {
        val qtdNumeros = Random.nextInt(6, 16) // Gera um número aleatório entre 6 e 15
        val numeros = mutableListOf<Int>()

        repeat(qtdNumeros) {
            var numeroAleatorio: Int
            do {
                numeroAleatorio = Random.nextInt(1, 61) // Gera um número aleatório entre 1 e 60
            } while (numeros.contains(numeroAleatorio))

            numeros.add(numeroAleatorio)
        }

        // Aqui você pode usar os números gerados como preferir, exibir em um TextView, por exemplo:
        val numerosFormatados = numeros.sorted().joinToString(", ")
        // Exemplo de exibição em um TextView:
        // textViewResultados.text = "Seus números da Mega-Sena são: $numerosFormatados"
    }
}
