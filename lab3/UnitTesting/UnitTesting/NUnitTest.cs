using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks; 

namespace UnitTesting
{
    [TestFixture]
    class NUnitTest
    {
       
            [TestCase]
            public void TestCase1()
            {
                Assert.AreEqual(Triangle.IsTriangleExist(4, 2, 5), false);
                Assert.AreEqual(Triangle.IsTriangleExist(7, 2, 19), true);
                Assert.AreEqual(Triangle.IsTriangleExist(2, 4, 6), true);
            }
            [TestCase]
            public void TestCase2()
            {
                Assert.AreEqual(Triangle.IsTriangleExist(-1, 84, 123), false);
                Assert.AreEqual(Triangle.IsTriangleExist(1, -1, 134), false);
                Assert.AreEqual(Triangle.IsTriangleExist(1, 45, -1), false);
            }
            [TestCase]
            public void TestCase3()
            {
                Assert.AreEqual(Triangle.IsTriangleExist(-1, -2, -3), false);
            }
            [TestCase]
            public void TestCase4()
            {
                Assert.AreEqual(Triangle.IsTriangleExist(10, 20, 30), false);
            }
            [TestCase]
            public void TestCase5()
            {
                Assert.AreEqual(Triangle.IsTriangleExist(5, 2, 6), false);
                Assert.AreEqual(Triangle.IsTriangleExist(1, 0, 8), false);
                Assert.AreEqual(Triangle.IsTriangleExist(1, 4, 8), false);
            }
            [TestCase]
            public void TestCase6()
            {
                Assert.AreEqual(Triangle.IsTriangleExist(float.MaxValue, float.MaxValue, float.MaxValue), false);
            }
            [TestCase]
            public void TestCase7()
            {
                Assert.AreEqual(Triangle.IsTriangleExist(float.MinValue, float.MinValue, float.MinValue), false);
            }
            [TestCase]
            public void TestCase8()
            {
                Assert.AreEqual(Triangle.IsTriangleExist(22.22f, 33.33f, 22.22f), true);
            }
            [TestCase]
            public void TestCase9()
            {
                Assert.AreEqual(Triangle.IsTriangleExist(float.MaxValue, 1, 1), false);
                Assert.AreEqual(Triangle.IsTriangleExist(1, float.MaxValue, 1), false);
                Assert.AreEqual(Triangle.IsTriangleExist(1, 1, float.MaxValue), false);
            }
            [TestCase]
            public void TestCase10()
            {
                for (float i = 1; i < 9999; i += 0.01f)
                    Assert.AreEqual(Triangle.IsTriangleExist(i, i, i), true);
            }
        }
}
