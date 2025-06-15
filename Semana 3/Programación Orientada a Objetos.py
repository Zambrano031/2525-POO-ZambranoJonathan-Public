class ClimaSemanal:
    def __init__(self):
        self.__temperaturas = []  # Encapsulamiento: atributo privado

    def ingresar_temperaturas(self):
        for i in range(7):
            temp = float(input(f"Ingrese la temperatura del día {i + 1}: "))
            self.__temperaturas.append(temp)

    def calcular_promedio(self):
        if len(self.__temperaturas) == 0:
            return 0
        return sum(self.__temperaturas) / len(self.__temperaturas)

    def mostrar_promedio(self):
        promedio = self.calcular_promedio()
        print(f"\nEl promedio semanal de temperatura es: {promedio:.2f} °C")


# Programa principal
def main():
    print("PROMEDIO SEMANAL DEL CLIMA - POO")
    clima = ClimaSemanal()
    clima.ingresar_temperaturas()
    clima.mostrar_promedio()

if __name__ == "__main__":
    main()
