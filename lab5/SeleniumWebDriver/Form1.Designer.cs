namespace SeleniumWebDriver
{
    partial class Form1
    {
        /// <summary>
        /// Обязательная переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Требуемый метод для поддержки конструктора — не изменяйте 
        /// содержимое этого метода с помощью редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            this.StartFirstTestButtonClick = new System.Windows.Forms.Button();
            this.StopFirstTestButton = new System.Windows.Forms.Button();
            this.StartSecondTestButton = new System.Windows.Forms.Button();
            this.StopSecondTestButton = new System.Windows.Forms.Button();
            this.panel1 = new System.Windows.Forms.Panel();
            this.panel2 = new System.Windows.Forms.Panel();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // StartFirstTestButtonClick
            // 
            this.StartFirstTestButtonClick.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.StartFirstTestButtonClick.Location = new System.Drawing.Point(39, 45);
            this.StartFirstTestButtonClick.Name = "StartFirstTestButtonClick";
            this.StartFirstTestButtonClick.Size = new System.Drawing.Size(160, 88);
            this.StartFirstTestButtonClick.TabIndex = 0;
            this.StartFirstTestButtonClick.Text = "Тестирование 1";
            this.StartFirstTestButtonClick.UseVisualStyleBackColor = false;
            this.StartFirstTestButtonClick.Click += new System.EventHandler(this.StartFirstTestButtonClick_Click);
            // 
            // StopFirstTestButton
            // 
            this.StopFirstTestButton.BackColor = System.Drawing.Color.Red;
            this.StopFirstTestButton.Location = new System.Drawing.Point(341, 45);
            this.StopFirstTestButton.Name = "StopFirstTestButton";
            this.StopFirstTestButton.Size = new System.Drawing.Size(160, 88);
            this.StopFirstTestButton.TabIndex = 1;
            this.StopFirstTestButton.Text = "Остановить тестирование 1";
            this.StopFirstTestButton.UseVisualStyleBackColor = false;
            this.StopFirstTestButton.Click += new System.EventHandler(this.StopFirstTestButton_Click);
            // 
            // StartSecondTestButton
            // 
            this.StartSecondTestButton.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.StartSecondTestButton.Location = new System.Drawing.Point(39, 173);
            this.StartSecondTestButton.Name = "StartSecondTestButton";
            this.StartSecondTestButton.Size = new System.Drawing.Size(165, 88);
            this.StartSecondTestButton.TabIndex = 2;
            this.StartSecondTestButton.Text = "Тестирование 2";
            this.StartSecondTestButton.UseVisualStyleBackColor = false;
            this.StartSecondTestButton.Click += new System.EventHandler(this.StartSecondTestButton_Click);
            // 
            // StopSecondTestButton
            // 
            this.StopSecondTestButton.BackColor = System.Drawing.Color.Red;
            this.StopSecondTestButton.Location = new System.Drawing.Point(329, 6);
            this.StopSecondTestButton.Name = "StopSecondTestButton";
            this.StopSecondTestButton.Size = new System.Drawing.Size(165, 88);
            this.StopSecondTestButton.TabIndex = 3;
            this.StopSecondTestButton.Text = "Остановить тестирование 2";
            this.StopSecondTestButton.UseVisualStyleBackColor = false;
            this.StopSecondTestButton.Click += new System.EventHandler(this.StopSecondTestButton_Click);
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.panel1.Controls.Add(this.StopSecondTestButton);
            this.panel1.Location = new System.Drawing.Point(12, 167);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(520, 102);
            this.panel1.TabIndex = 4;
            // 
            // panel2
            // 
            this.panel2.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.panel2.Location = new System.Drawing.Point(12, 37);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(520, 102);
            this.panel2.TabIndex = 5;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(544, 307);
            this.Controls.Add(this.StartSecondTestButton);
            this.Controls.Add(this.StopFirstTestButton);
            this.Controls.Add(this.StartFirstTestButtonClick);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.panel2);
            this.Name = "Form1";
            this.Text = "Form1";
            this.panel1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button StartFirstTestButtonClick;
        private System.Windows.Forms.Button StopFirstTestButton;
        private System.Windows.Forms.Button StartSecondTestButton;
        private System.Windows.Forms.Button StopSecondTestButton;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
    }
}

