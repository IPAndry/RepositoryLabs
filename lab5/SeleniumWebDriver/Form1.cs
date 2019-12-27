using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SeleniumWebDriver
{
    public partial class Form1 : Form
    {
        IWebDriver BrowserGoogleChrome;
        IWebDriver BrowserGoogleChromeSecondTest;

        public Form1()
        {
            InitializeComponent();
        }

        private void StartFirstTestButtonClick_Click(object sender, EventArgs e)
        {
            //Тест-кейс № 4. Выбор несуществующего населённого пункта для доставки.
            BrowserGoogleChrome = new OpenQA.Selenium.Chrome.ChromeDriver();
            BrowserGoogleChrome.Manage().Window.Maximize();
            //Зайти на сайт https://rozetka.com.ua/.
            BrowserGoogleChrome.Navigate().GoToUrl("https://rozetka.com.ua/");
            

            
            IWebElement Button1 = BrowserGoogleChrome.FindElement(By.Name("close"));
            Button1.Click();
            //Нажать на кнопку с уже выбранным городом (прим. Одесса). 
            IWebElement Button2 = BrowserGoogleChrome.FindElement(By.Name("city"));
            Button2.Click();

            IWebElement SearhInputLine = BrowserGoogleChrome.FindElement(By.Name("suggest_locality"));

            //Заполнить поле "Или введите другой населенный пункт Украины" случайным символьным значением (прим. БГТУ). 
            SearhInputLine.SendKeys("БГТУ" + OpenQA.Selenium.Keys.Enter);
            //Ожидаемый результат: Появляется всплывающее окно с предупреждением "Город не найден. Проверьте написание или введите ближайший к вам!".

            Thread.Sleep(10000);
            BrowserGoogleChrome.Quit();

        }

        private void StopFirstTestButton_Click(object sender, EventArgs e)
        {
            BrowserGoogleChrome.Quit();
        }

        private void StartSecondTestButton_Click(object sender, EventArgs e)
        {
            //№3  Тестирование фильтрации услуг
            BrowserGoogleChromeSecondTest = new OpenQA.Selenium.Chrome.ChromeDriver();
            BrowserGoogleChromeSecondTest.Manage().Window.Maximize();
            //1. Зайти на сайт https://my.rozetka.com.ua/
            BrowserGoogleChromeSecondTest.Navigate().GoToUrl("https://rozetka.com.ua/");

            //2. Перейти в раздел "Ноутбуки и компьютеры".
            IWebElement Razdel1 = BrowserGoogleChromeSecondTest.FindElement(By.XPath("//*[@id='2416']/a"));
            Razdel1.Click();

            //3. Перейти в раздел "Asus".
            IWebElement Razdel2 = BrowserGoogleChromeSecondTest.FindElement(By.ClassName("pab-items-i"));
            Razdel2.Click();

            //4. Выбрать товар (прим. Asus ROG Strix) нажав на него.
            IWebElement Notebook = BrowserGoogleChromeSecondTest.FindElement(By.XPath("//*[@id='catalog_goods_block']/div/div[1]/div[1]/div/div/div/div[3]/a"));
            Notebook.Click();

            Thread.Sleep(15000);
            //5. Нажать на кнопку "Купить". 
            try
            { 
            IWebElement Purch = BrowserGoogleChromeSecondTest.FindElement(By.XPath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/div/div[1]/div[2]/div/div[3]/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/form/span/span/button"));
            Purch.Click();
            }
            catch
            {
                Console.WriteLine("Попробуй в другой раз");
            }

            Thread.Sleep(20000);
            //6. Ввести в поле количества большое значение (прим. 999999).
            try
            {
                IWebElement Quantity = BrowserGoogleChromeSecondTest.FindElement(By.XPath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[3]/input"));
                Quantity.SendKeys("99999999" + OpenQA.Selenium.Keys.Enter);
            }
            catch
            {
                Console.WriteLine("Поробуй в другой раз");

            }
            Thread.Sleep(20000);
            //7. Нажать на кнопку "Оформить заказ"
            IWebElement Buy = BrowserGoogleChromeSecondTest.FindElement(By.XPath("/html/body/div[1]/div/div[2]/div[2]/h2"));
            Buy.Click();

            Thread.Sleep(10000);
            BrowserGoogleChromeSecondTest.Quit();

        }

            private void StopSecondTestButton_Click(object sender, EventArgs e)
        {
            BrowserGoogleChromeSecondTest.Quit();
        }
    }
}
