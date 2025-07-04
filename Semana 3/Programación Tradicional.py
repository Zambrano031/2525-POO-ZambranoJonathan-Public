# Función para ingresar temperaturas diarias
def ingresar_temperaturas():
    temperaturas = []
    for i in range(7):
        temp = float(input(f"Ingrese la temperatura del día {i + 1}: "))
        temperaturas.append(temp)
    return temperaturas

# Función para calcular el promedio semanal
def calcular_promedio(temperaturas):
    total = sum(temperaturas)
    promedio = total / len(temperaturas)
    return promedio

# Programa principal
def main():
    print("PROMEDIO SEMANAL DEL CLIMA - MÉTODO TRADICIONAL")
    temperaturas = ingresar_temperaturas()
    promedio = calcular_promedio(temperaturas)
    print(f"\nEl promedio semanal de temperatura es: {promedio:.2f} °C")

if __name__ == "__main__":
    main()
