<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class FormMain
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.FahrenheitLabel = New System.Windows.Forms.Label()
        Me.CelsiusLabel = New System.Windows.Forms.Label()
        Me.FeetLabel = New System.Windows.Forms.Label()
        Me.MetersLabel = New System.Windows.Forms.Label()
        Me.PoundsLabel = New System.Windows.Forms.Label()
        Me.KilogramsLabel = New System.Windows.Forms.Label()
        Me.ConvertButton = New System.Windows.Forms.Button()
        Me.CelsiusTextBox = New System.Windows.Forms.TextBox()
        Me.MetersTextBox = New System.Windows.Forms.TextBox()
        Me.KilogramsTextBox = New System.Windows.Forms.TextBox()
        Me.KelvinLabel = New System.Windows.Forms.Label()
        Me.FahrenheitUpDown = New System.Windows.Forms.NumericUpDown()
        Me.FeetUpDown = New System.Windows.Forms.NumericUpDown()
        Me.PoundsUpDown = New System.Windows.Forms.NumericUpDown()
        Me.KelvinTextBox = New System.Windows.Forms.TextBox()
        Me.InchesTextBox = New System.Windows.Forms.TextBox()
        Me.StoneTextBox = New System.Windows.Forms.TextBox()
        Me.InchesLabel = New System.Windows.Forms.Label()
        Me.StoneLabel = New System.Windows.Forms.Label()
        CType(Me.FahrenheitUpDown,System.ComponentModel.ISupportInitialize).BeginInit
        CType(Me.FeetUpDown,System.ComponentModel.ISupportInitialize).BeginInit
        CType(Me.PoundsUpDown,System.ComponentModel.ISupportInitialize).BeginInit
        Me.SuspendLayout
        '
        'FahrenheitLabel
        '
        Me.FahrenheitLabel.AutoSize = true
        Me.FahrenheitLabel.Location = New System.Drawing.Point(46, 35)
        Me.FahrenheitLabel.Name = "FahrenheitLabel"
        Me.FahrenheitLabel.Size = New System.Drawing.Size(100, 13)
        Me.FahrenheitLabel.TabIndex = 0
        Me.FahrenheitLabel.Text = "Degrees Fahrenheit"
        '
        'CelsiusLabel
        '
        Me.CelsiusLabel.AutoSize = true
        Me.CelsiusLabel.Location = New System.Drawing.Point(205, 35)
        Me.CelsiusLabel.Name = "CelsiusLabel"
        Me.CelsiusLabel.Size = New System.Drawing.Size(83, 13)
        Me.CelsiusLabel.TabIndex = 1
        Me.CelsiusLabel.Text = "Degrees Celsius"
        '
        'FeetLabel
        '
        Me.FeetLabel.AutoSize = true
        Me.FeetLabel.Location = New System.Drawing.Point(46, 106)
        Me.FeetLabel.Name = "FeetLabel"
        Me.FeetLabel.Size = New System.Drawing.Size(28, 13)
        Me.FeetLabel.TabIndex = 2
        Me.FeetLabel.Text = "Feet"
        '
        'MetersLabel
        '
        Me.MetersLabel.AutoSize = true
        Me.MetersLabel.Location = New System.Drawing.Point(205, 106)
        Me.MetersLabel.Name = "MetersLabel"
        Me.MetersLabel.Size = New System.Drawing.Size(39, 13)
        Me.MetersLabel.TabIndex = 3
        Me.MetersLabel.Text = "Meters"
        '
        'PoundsLabel
        '
        Me.PoundsLabel.AutoSize = true
        Me.PoundsLabel.Location = New System.Drawing.Point(46, 177)
        Me.PoundsLabel.Name = "PoundsLabel"
        Me.PoundsLabel.Size = New System.Drawing.Size(43, 13)
        Me.PoundsLabel.TabIndex = 4
        Me.PoundsLabel.Text = "Pounds"
        '
        'KilogramsLabel
        '
        Me.KilogramsLabel.AutoSize = true
        Me.KilogramsLabel.Location = New System.Drawing.Point(205, 177)
        Me.KilogramsLabel.Name = "KilogramsLabel"
        Me.KilogramsLabel.Size = New System.Drawing.Size(52, 13)
        Me.KilogramsLabel.TabIndex = 5
        Me.KilogramsLabel.Text = "Kilograms"
        '
        'ConvertButton
        '
        Me.ConvertButton.Location = New System.Drawing.Point(211, 287)
        Me.ConvertButton.Name = "ConvertButton"
        Me.ConvertButton.Size = New System.Drawing.Size(75, 23)
        Me.ConvertButton.TabIndex = 4
        Me.ConvertButton.Text = "&Convert"
        Me.ConvertButton.UseVisualStyleBackColor = true
        '
        'CelsiusTextBox
        '
        Me.CelsiusTextBox.Location = New System.Drawing.Point(208, 51)
        Me.CelsiusTextBox.Name = "CelsiusTextBox"
        Me.CelsiusTextBox.ReadOnly = true
        Me.CelsiusTextBox.Size = New System.Drawing.Size(100, 20)
        Me.CelsiusTextBox.TabIndex = 8
        Me.CelsiusTextBox.TabStop = false
        '
        'MetersTextBox
        '
        Me.MetersTextBox.Location = New System.Drawing.Point(208, 122)
        Me.MetersTextBox.Name = "MetersTextBox"
        Me.MetersTextBox.ReadOnly = true
        Me.MetersTextBox.Size = New System.Drawing.Size(100, 20)
        Me.MetersTextBox.TabIndex = 10
        Me.MetersTextBox.TabStop = false
        '
        'KilogramsTextBox
        '
        Me.KilogramsTextBox.Location = New System.Drawing.Point(208, 193)
        Me.KilogramsTextBox.Name = "KilogramsTextBox"
        Me.KilogramsTextBox.ReadOnly = true
        Me.KilogramsTextBox.Size = New System.Drawing.Size(100, 20)
        Me.KilogramsTextBox.TabIndex = 12
        Me.KilogramsTextBox.TabStop = false
        '
        'KelvinLabel
        '
        Me.KelvinLabel.AutoSize = true
        Me.KelvinLabel.Location = New System.Drawing.Point(347, 35)
        Me.KelvinLabel.Name = "KelvinLabel"
        Me.KelvinLabel.Size = New System.Drawing.Size(41, 13)
        Me.KelvinLabel.TabIndex = 13
        Me.KelvinLabel.Text = "Kelvins"
        '
        'FahrenheitUpDown
        '
        Me.FahrenheitUpDown.Location = New System.Drawing.Point(49, 52)
        Me.FahrenheitUpDown.Maximum = New Decimal(New Integer() {212, 0, 0, 0})
        Me.FahrenheitUpDown.Name = "FahrenheitUpDown"
        Me.FahrenheitUpDown.Size = New System.Drawing.Size(120, 20)
        Me.FahrenheitUpDown.TabIndex = 14
        '
        'FeetUpDown
        '
        Me.FeetUpDown.Location = New System.Drawing.Point(49, 122)
        Me.FeetUpDown.Name = "FeetUpDown"
        Me.FeetUpDown.Size = New System.Drawing.Size(120, 20)
        Me.FeetUpDown.TabIndex = 15
        '
        'PoundsUpDown
        '
        Me.PoundsUpDown.Location = New System.Drawing.Point(49, 193)
        Me.PoundsUpDown.Name = "PoundsUpDown"
        Me.PoundsUpDown.Size = New System.Drawing.Size(120, 20)
        Me.PoundsUpDown.TabIndex = 16
        '
        'KelvinTextBox
        '
        Me.KelvinTextBox.Location = New System.Drawing.Point(350, 51)
        Me.KelvinTextBox.Name = "KelvinTextBox"
        Me.KelvinTextBox.ReadOnly = true
        Me.KelvinTextBox.Size = New System.Drawing.Size(100, 20)
        Me.KelvinTextBox.TabIndex = 17
        Me.KelvinTextBox.TabStop = false
        '
        'InchesTextBox
        '
        Me.InchesTextBox.Location = New System.Drawing.Point(350, 122)
        Me.InchesTextBox.Name = "InchesTextBox"
        Me.InchesTextBox.ReadOnly = true
        Me.InchesTextBox.Size = New System.Drawing.Size(100, 20)
        Me.InchesTextBox.TabIndex = 18
        Me.InchesTextBox.TabStop = false
        '
        'StoneTextBox
        '
        Me.StoneTextBox.Location = New System.Drawing.Point(350, 193)
        Me.StoneTextBox.Name = "StoneTextBox"
        Me.StoneTextBox.ReadOnly = true
        Me.StoneTextBox.Size = New System.Drawing.Size(100, 20)
        Me.StoneTextBox.TabIndex = 19
        Me.StoneTextBox.TabStop = false
        '
        'InchesLabel
        '
        Me.InchesLabel.AutoSize = true
        Me.InchesLabel.Location = New System.Drawing.Point(347, 106)
        Me.InchesLabel.Name = "InchesLabel"
        Me.InchesLabel.Size = New System.Drawing.Size(39, 13)
        Me.InchesLabel.TabIndex = 20
        Me.InchesLabel.Text = "Inches"
        '
        'StoneLabel
        '
        Me.StoneLabel.AutoSize = true
        Me.StoneLabel.Location = New System.Drawing.Point(347, 177)
        Me.StoneLabel.Name = "StoneLabel"
        Me.StoneLabel.Size = New System.Drawing.Size(35, 13)
        Me.StoneLabel.TabIndex = 21
        Me.StoneLabel.Text = "Stone"
        '
        'FormMain
        '
        Me.AcceptButton = Me.ConvertButton
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6!, 13!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(496, 345)
        Me.Controls.Add(Me.StoneLabel)
        Me.Controls.Add(Me.InchesLabel)
        Me.Controls.Add(Me.StoneTextBox)
        Me.Controls.Add(Me.InchesTextBox)
        Me.Controls.Add(Me.KelvinTextBox)
        Me.Controls.Add(Me.PoundsUpDown)
        Me.Controls.Add(Me.FeetUpDown)
        Me.Controls.Add(Me.FahrenheitUpDown)
        Me.Controls.Add(Me.KelvinLabel)
        Me.Controls.Add(Me.KilogramsTextBox)
        Me.Controls.Add(Me.MetersTextBox)
        Me.Controls.Add(Me.CelsiusTextBox)
        Me.Controls.Add(Me.KilogramsLabel)
        Me.Controls.Add(Me.PoundsLabel)
        Me.Controls.Add(Me.FeetLabel)
        Me.Controls.Add(Me.CelsiusLabel)
        Me.Controls.Add(Me.FahrenheitLabel)
        Me.Controls.Add(Me.ConvertButton)
        Me.Controls.Add(Me.MetersLabel)
        Me.Name = "FormMain"
        Me.Text = "Unit Converter"
        CType(Me.FahrenheitUpDown,System.ComponentModel.ISupportInitialize).EndInit
        CType(Me.FeetUpDown,System.ComponentModel.ISupportInitialize).EndInit
        CType(Me.PoundsUpDown,System.ComponentModel.ISupportInitialize).EndInit
        Me.ResumeLayout(false)
        Me.PerformLayout

End Sub
    Friend WithEvents FahrenheitLabel As System.Windows.Forms.Label
    Friend WithEvents CelsiusLabel As System.Windows.Forms.Label
    Friend WithEvents FeetLabel As System.Windows.Forms.Label
    Friend WithEvents MetersLabel As System.Windows.Forms.Label
    Friend WithEvents PoundsLabel As System.Windows.Forms.Label
    Friend WithEvents KilogramsLabel As System.Windows.Forms.Label
    Friend WithEvents ConvertButton As System.Windows.Forms.Button
    Friend WithEvents CelsiusTextBox As System.Windows.Forms.TextBox
    Friend WithEvents MetersTextBox As System.Windows.Forms.TextBox
    Friend WithEvents KilogramsTextBox As System.Windows.Forms.TextBox
    Friend WithEvents KelvinLabel As System.Windows.Forms.Label
    Friend WithEvents FahrenheitUpDown As System.Windows.Forms.NumericUpDown
    Friend WithEvents FeetUpDown As System.Windows.Forms.NumericUpDown
    Friend WithEvents PoundsUpDown As System.Windows.Forms.NumericUpDown
    Friend WithEvents KelvinTextBox As System.Windows.Forms.TextBox
    Friend WithEvents InchesTextBox As System.Windows.Forms.TextBox
    Friend WithEvents StoneTextBox As System.Windows.Forms.TextBox
    Friend WithEvents InchesLabel As System.Windows.Forms.Label
    Friend WithEvents StoneLabel As System.Windows.Forms.Label

End Class
