#include <iostream>
#include <cmath>
using namespace std;
class feet_inch;
class meter_centimeter{
    int meter, centimeter;
public:
    meter_centimeter(int meter, int centimeter){
        this->meter=meter;
        this->centimeter=centimeter;
    }
    void display();
    friend meter_centimeter add(meter_centimeter x, feet_inch y);
    friend feet_inch add (feet_inch x, meter_centimeter y);
    friend meter_centimeter sub(meter_centimeter x, feet_inch y);
    friend feet_inch sub (feet_inch x, meter_centimeter y);
};

class feet_inch{
    int feet, inch;
public:
    feet_inch(int feet,int inch){
        this->feet=feet;
        this->inch=inch;
    }
    void display();
    friend feet_inch add (feet_inch x, meter_centimeter y);
    friend meter_centimeter add(meter_centimeter x, feet_inch y);
    friend feet_inch sub (feet_inch x, meter_centimeter y);
    friend meter_centimeter sub(meter_centimeter x, feet_inch y);
};

meter_centimeter add(meter_centimeter x, feet_inch y){
    meter_centimeter temp(0,0);
    temp.centimeter=x.centimeter+(x.meter*100)+(y.feet*30.48)+(y.inch*2.54);
    if (temp.centimeter<0){
        temp.centimeter=-temp.centimeter;
    }
    temp.meter=0;
    return temp;
}

feet_inch add(feet_inch x, meter_centimeter y){
    feet_inch temp(0,0);
    temp.inch=x.inch+(x.feet*12)+(y.meter*39.3701)+(y.centimeter*0.393701);
    if (temp.inch<0){
        temp.inch=-temp.inch;
    }
    temp.feet=0;
    return temp;
}

meter_centimeter sub(meter_centimeter x, feet_inch y){
meter_centimeter temp(0,0);
    temp.centimeter=x.centimeter+(x.meter*100)-(y.feet*30.48)-(y.inch*2.54);
    if (temp.centimeter<0){
        temp.centimeter=-temp.centimeter;
    }
temp.meter=0;
return temp;
}

feet_inch sub(feet_inch x, meter_centimeter y){
feet_inch temp(0,0);
    temp.inch=x.inch+(x.feet*12)-(y.meter*39.3701)-(y.centimeter*0.393701);
    if (temp.inch<0){
        temp.inch=-temp.inch;
    }
temp.feet=0;
return temp;
}

void meter_centimeter::display() {
    if (centimeter>=100){
        meter+=floor((centimeter/100));
        centimeter= (centimeter%100);
    }
    cout<<meter<<" m & "<<centimeter<<" cm"<<endl;
}



void feet_inch::display() {
    if (inch>=12){
        feet+=floor((inch/12));
        inch= (inch%12);
    }
    cout<<feet<<" Ft & "<<inch<<" in"<<endl;
}




int main() {
    int m, cm, f, i;
    cout << "Enter the value in Meter: ";
    cin >> m;
    cout << "Enter the value in Centimeter: ";
    cin >> cm;
    cout << "Enter the value in Feet: ";
    cin >> f;
    cout << "Enter the value in Inch: ";
    cin >> i;
    meter_centimeter m1(m, cm);
    meter_centimeter m2(0, 0);
    meter_centimeter m3(0, 0);
    feet_inch f1(f, i);
    feet_inch f2(0, 0);
    feet_inch f3(0, 0);
    m1.display();
    f1.display();
    int ch, ch1, ch2;
    char ch3 = 1;
    do {
        cout << "Enter your Choice:" << endl;
        cout << "1.Addition" << endl;
        cout << "2.Subtraction" << endl;
        cout << "3.Exit" << endl;
        cout << "Choice: ";
        cin >> ch;
        switch (ch) {
                case 1: {
                    cout << "Addition." << endl;
                    cout << "Enter your Choice:" << endl;
                    cout << "1.Display result in Meter-Centimeter" << endl;
                    cout << "2.Display result in Feet-Inch" << endl;
                    cout << "Choice: ";
                    cin >> ch1;
                    if (ch1 == 1) {
                        cout << "Displaying result in Meter-Centimeter." << endl;
                        m2 = add(m1, f1);
                        m2.display();
                        break;
                    } else if (ch1 == 2) {
                        cout << "Displaying result in Feet-Inch." << endl;
                        f2 = add(f1, m1);
                        f2.display();
                        break;
                    } else {
                        cout << "As invalid choice" << endl;
                        cout << "Displaying result in both Meter-Centimeter & Feet-Inch." << endl;
                        m2 = add(m1, f1);
                        f2 = add(f1, m1);
                        m2.display();
                        f2.display();
                        break;
                    }
                }
                case 2: {
                    cout << "Subtraction." << endl;
                    cout << "Enter your Choice:" << endl;
                    cout << "1.Display result in Meter-Centimeter" << endl;
                    cout << "2.Display result in Feet-Inch" << endl;
                    cout << "Choice: ";
                    cin >> ch2;
                    if (ch2 == 1) {
                        cout << "Displaying result in Meter-Centimeter." << endl;
                        m3 = sub(m1, f1);
                        m3.display();
                        break;
                    } else if (ch2 == 2) {
                        cout << "Displaying result in Feet-Inch." << endl;
                        f3 = sub(f1, m1);
                        f3.display();
                        break;
                    } else {
                        cout << "As invalid choice" << endl;
                        cout << "Displaying result in both Meter-Centimeter & Feet-Inch." << endl;
                        m3 = sub(m1, f1);
                        f3 = sub(f1, m1);
                        m3.display();
                        f3.display();
                        break;
                    }

                }
                case 3: {
                    break;
                }
        }
    } while (ch==1||ch==2);
}
