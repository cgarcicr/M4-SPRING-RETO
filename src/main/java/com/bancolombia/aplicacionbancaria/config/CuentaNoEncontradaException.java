package com.bancolombia.aplicacionbancaria.config;

public class CuentaNoEncontradaException extends RuntimeException{

    public class CuentaNoEncontradaExc extends RuntimeException {
        public CuentaNoEncontradaExc(String message) {
            super(message);
        }
    }

    public class SaldoInsuficienteException extends RuntimeException {
        public SaldoInsuficienteException(String message) {
            super(message);
        }
    }

    public class TransaccionNoPermitidaException extends RuntimeException {
        public TransaccionNoPermitidaException(String message) {
            super(message);
        }

}}
