import java.util.Scanner;

public class CalculatingOfRent {

    // константы тарифов
    static final double Tsod = 18.69;       // Тариф содержания
    static final double Tcap = 5.80;        // Тариф капитального ремонта
    static final double Totop = 21.67;      // Тариф отопления
    static final double Thvs = 18.50;       // Тариф холодного водоснабжения
    static final double Tgvs = 123.58;      // Тариф горячего водоснабжения
    static final double Tvod = 14.50;       // Тариф водоотведения
    static final double Tel = 2.35;         // Тариф электроэнергии
    static final double Tgas = 4.72;        // Тариф за газ

    // переменные, с данными плательщика по параметрам
    public static double Vkv;               // Площадь квартиры введенныая пользователем
    public static double Vhvs;              // Объем израсходованного холодного водоснабжения
    public static double Vgvs;              // Объем израсходованного горячего водоснабжения
    public static double Vvod;              // Объем водоотведения
    public static double Vel;               // Объем израсходованной электроэнергии
    public static double Vgas;              // Объем израсходованного газа

    // итоговые суммы по каждому парметру
    public static double Ssod;              // Итоговая сумма по содержанию жил.здания
    public static double Scap;              // Итоговая сумма по капитальному ремонту дома
    public static double Sotop;             // Мтоговая сумма по отоплению квартиры
    public static double Shvs;              // Итоговая сумма по холодному водоснабжению
    public static double Sgvs;              // Итоговая сумма по горячему водоснабжению
    public static double Svod;              // Итоговая сумма по водоотведению
    public static double Sel;               // Итоговая сумма по электроэнергии
    public static double Sgas;              // Итоговая сумма по газу
    public static double Stotal;            // Итоговая сумма по платежу за квартплату

    public static void main(String[] args) {

        printTariffs();     // Вывод на экран стоимость трафиов за 1 единицу ресурса
        // Получаем от пользователя необходимые данные
        System.out.print("\n1. Введите количество жил.площади = ");
        Vkv = Input();
        System.out.print("2. Введите объем потребленного холодного водоснабжения = ");
        Vhvs = Input();
        System.out.print("3. Введите объем потребленного горячего водоснабжения = ");
        Vgvs = Input();
        Vvod = Vgvs + Vhvs;             //объем водоотведения - сумма горячего и холодного водоснабжения
        System.out.print("4. Введите объем потребленной электроэнергии = ");
        Vel = Input();
        System.out.print("5. Введите объем потребленного газа = ");
        Vgas = Input();

        //считаем по формулам стоимость услуг
        Ssod = Tsod * Vkv;              // формула расчета итоговой суммы по содержанию
        Scap = Tcap * Vkv;              // формула расчета итоговой суммы по капитальному ремонту
        Sotop = Totop * Vkv;            // формула расчета итоговой суммы по отоплению
        Shvs = Thvs * Vhvs;             // формула расчета итоговой суммы по холодному водоснабжению
        Sgvs = Tgvs * Vgvs;             // формула расчета итоговой суммы по горячему водоснабжению
        Svod = Tvod * Vvod;             // формула расчета итоговой суммы по водоотведению.
        Sel = Tel * Vel;                // формула расчета итоговой суммы по электроэнергии.
        Sgas = Tgas * Vgas;             // формула расчета итоговой суммы по газу
        // формула расчета итоговой суммы по всему платежу
        Stotal = Ssod+Scap+Sotop+Shvs+Sgvs+Svod+Sel+Sgas;

        //выводим результат на экран
        printTotal();
    }

    public static double Input() //организовываем ввод данных с клавиатуры вместе с защитой от "дурака"
    {
        Scanner in = new Scanner(System.in);
        boolean valid = true;
        double d = 0;
        do {
            do {
                try {
                    if (d < 0) System.out.println("Пожалуйста введите положительное число ");;
                    d = in.nextDouble();//считываем вещественное число
                    valid = true;
                } catch (Exception e) {
                    System.out.println("Пожалуйста введите положительное число ");
                    in = new Scanner(System.in);
                    valid = false;
                    break;
                }
            } while (!valid || d < 0);
        } while (!valid || d < 0);
        return d;
    }

    // подсказка с тарифами за 1 единицу потребляемого ресурса
    public static void printTariffs() {
        System.out.println("Добро пожаловать в Калькулятор квартплаты.\n\nСтоимость тарифов за 1 единицу потребляемого ресурса");
        System.out.println("1. Плата за содержание жил.площадь 1м2 = " + Tsod);
        System.out.println("2. Капитальный ремонт дома 1м2 = " + Tcap);
        System.out.println("3. Центральное отопление 1м2 = " + Totop);
        System.out.println("4. Горячее водоснабжение 1м3 = " + Thvs);
        System.out.println("5. Холодное водоснабжение 1м3 = " + Tgvs);
        System.out.println("6. Водоотведение 1м3 = " + Tvod);
        System.out.println("7. Электроэнергия 1кВт/ч = " + Tel);
        System.out.println("8. Газ 1м3 = " + Tgas);
    }

    // вывод на экран итоговой суммы
    public static void printTotal() {
        System.out.println("\nСтоимость платежей потребленного ресурса");
        System.out.format("1. Плата за содержание жил.площадь = %.2f р.%n", Ssod);
        System.out.format("2. Капитальный ремонт дома = %.2f р.%n", Scap);
        System.out.format("3. Центральное отопление = %.2f р.%n", Sotop);
        System.out.format("4. Горячее водоснабжение = %.2f р.%n", Sgvs);
        System.out.format("5. Холодное водоснабжение = %.2f р.%n", Shvs);
        System.out.format("6. Водоотведение = %.2f р.%n", Svod);
        System.out.format("7. Электроэнергия = %.2f р.%n", Sel);
        System.out.format("8. Газ = %.2f р.%n", Sgas);
        System.out.format("Итоговая сумма = %.2f р.%n", Stotal);
    }
}
