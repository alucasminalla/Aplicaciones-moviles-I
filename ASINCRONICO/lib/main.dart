import 'package:flutter/material.dart';
import 'mockapi.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

 
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'MockApi Example',
      home: const HomeScreen(),
    );
  }
}

class HomeScreen extends StatefulWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final MockApi _mockApi = MockApi();
  bool _isLoading = false;
  int _result = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('MockApi Example'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            _buildButton(context, 'Ferrari', Colors.green, _mockApi.getFerrariInteger),
            _buildButton(context, 'Hyundai', Colors.orange, _mockApi.getHyundaiInteger),
            _buildButton(context, 'Fisher Price', Colors.red, _mockApi.getFisherPriceInteger),
            if (_isLoading) LinearProgressIndicator(), // Muestra la barra de progreso si está cargando
            if (_result != 0) Text('Número Aleatorio: $_result'), // Muestra el número aleatorio si está disponible
          ],
        ),
      ),
    );
  }

  Widget _buildButton(BuildContext context, String label, Color color, Future<int> Function() onPressed) {
    return ElevatedButton(
      onPressed: () async {
        _startLoading(); // Inicia la carga
        await _handleButtonTap(context, label, onPressed);
        _stopLoading(); // Finaliza la carga
      },
      style: ElevatedButton.styleFrom(
        primary: color, // Establece el color de fondo del botón
      ),
      child: Text('Get $label Integer'),
    );
  }

  Future<void> _handleButtonTap(BuildContext context, String label, Future<int> Function() onPressed) async {
    try {
      final result = await onPressed();
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          content: Text('$label Integer: $result'),
        ),
      );
      setState(() {
        _result = result; // Actualiza el resultado
      });
    } catch (error) {
      print('Error: $error');
    }
  }

  void _startLoading() {
    setState(() {
      _isLoading = true; // Inicia la animación de carga
    });
  }

  void _stopLoading() {
    setState(() {
      _isLoading = false; // Finaliza la animación de carga
    });
  }
}

class MockApi {
  static final MockApi _mockapi = MockApi._internal();

  factory MockApi() {
    return _mockapi;
  }

  MockApi._internal();

  Future<int> _getInteger(int delayInSeconds) {
    return Future.delayed(
      Duration(seconds: delayInSeconds),
      () => 1 + DateTime.now().second % 100, // Modificar para evitar el error mencionado
    );
  }

  Future<int> getFerrariInteger() {
    return _getInteger(1);
  }

  Future<int> getHyundaiInteger() {
    return _getInteger(3);
  }

  Future<int> getFisherPriceInteger() {
    return _getInteger(10);
  }
}