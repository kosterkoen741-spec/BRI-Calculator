# BRI Calculator

[![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com/)
[![Language](https://img.shields.io/badge/Language-Kotlin-purple.svg)](https://kotlinlang.org/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Version](https://img.shields.io/badge/Version-1.1.0-orange.svg)](https://github.com/kosterkoen741-spec/BRI-Calculator/releases)

---

## 💡 What is the BRI Calculator?

The BRI Calculator helps you quickly understand whether your body shape falls within a healthy range. Body Roundness Index (BRI) is an advanced method that focuses on body shape and fat distribution, providing greater insight than traditional BMI.

### What is BRI?
BRI is a numerical value that estimates body fat and body shape based on your height and waist circumference. It specifically targets abdominal fat, which is strongly linked to health risks.

---

## 📐 How BRI is Calculated

BRI is calculated using your height and waist circumference (both measured in meters).

**Formula:**
$$\text{BRI} = 364.2 - 365.5 \times \sqrt{1 - \left(\frac{\text{waist circumference}}{\pi \times \text{height}}\right)^2}$$

**Example:**
If your waist circumference is 85 cm (0.85 m) and your height is 1.75 m:

1. **Calculate the component inside the formula:**
   $$\left(\frac{0.85}{\pi \times 1.75}\right)^2 \approx \left(\frac{0.85}{5.50}\right)^2 \approx (0.1545)^2 \approx 0.0239$$

2. **Calculate the square root component:**
   $$\sqrt{1 - 0.0239} = \sqrt{0.9761} \approx 0.988$$

3. **Calculate the final BRI score:**
   $$\text{BRI} = 364.2 - (365.5 \times 0.988) \approx 364.2 - 361.1 \approx 3.1$$

---

## 📊 BRI Categories

Your BRI value can be interpreted as follows:

- 🔹 **Less than 3.4:** Slim body (low body fat)
- 🟢 **3.5 – 5.4:** Healthy range
- 🟠 **5.5 – 6.9:** Increased body fat
- 🔴 **7.0 and higher:** High health risk

---

## ❤️ Why Use BRI?

BRI provides a better indication of health risks associated with visceral abdominal fat. Fat around the waist is strongly linked to conditions such as:
- Heart disease
- Type 2 diabetes
- High blood pressure

Because of this, BRI offers greater insight into health risks than BMI alone.

---

## ⚠️ Limitations of BRI

Although BRI is more advanced than BMI, it still has limitations. It does not measure body fat directly and does not fully account for:
- Muscle mass
- Bone structure
- Age and gender differences
- Fitness level

---

## 🩺 Tips for Interpreting Your BRI

- Use BRI as a guideline, not as a medical diagnosis.
- Combine it with other health indicators.
- Consult a healthcare professional for a complete evaluation.

> **Note:** BRI is a useful tool to gain insight into your body shape and potential health risks. However, it should always be viewed in the proper context, as your overall health depends on many factors.

---

## ✨ Features

- 🚀 **Fast & Lightweight:** Instant calculation with zero bloatware.
- 🎨 **Minimalist Design:** Clean, intuitive UI optimized for focus.
- 🧮 **Accurate Calculation:** Precise Body Roundness Index scoring and interpretation.
- 🌍 **Multilingual Support:** Fully translated into 12 major languages.
- 🔒 **Privacy Focused:** Your data stays strictly on your device.
- 🛠️ **100% Open Source:** Fully transparent and open for community contributions.

---

## 🌍 Multilingual Support

BRI Calculator is translated into:

- 🇳🇱 **Dutch**
- 🇬🇧 **English**
- 🇩🇪 **German**
- 🇫🇷 **French**
- 🇪🇸 **Spanish**
- 🇵🇹 **Portuguese**
- 🇮🇩 **Indonesian**
- 🇸🇦 **Arabic**
- 🇷🇺 **Russian**
- 🇮🇳 **Hindi**
- 🇧🇩 **Bengali**
- 🇨🇳 **Chinese**

---

## 🛠️ Tech Stack & Architecture

- **Language:** [Kotlin](https://kotlinlang.org/)
- **IDE:** [Android Studio](https://developer.android.com/studio)
- **Minimum SDK:** Android 8.0 (API level 26) or higher
- **UI Framework:** Android Jetpack Components
- **Architecture:** MVVM (Model-View-ViewModel)

---

## 🚀 Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

- [Android Studio](https://developer.android.com/studio)
- JDK 17 or higher
- Android SDK 34+

### Installation & Building

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/kosterkoen741-spec/BRI-Calculator.git](https://github.com/kosterkoen741-spec/BRI-Calculator.git)
