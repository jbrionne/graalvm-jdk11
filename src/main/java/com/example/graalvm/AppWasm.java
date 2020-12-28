package com.example.graalvm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
import org.graalvm.polyglot.io.ByteSequence;

public class AppWasm {

	public static void main(String[] args) throws IOException {

		String wasmFilePath = AppWasm.class.getResource("/floyd.wasm").getPath();

		System.out.println(wasmFilePath);

		byte[] binary = Files.readAllBytes(Paths.get(wasmFilePath));
		Context.Builder contextBuilder = Context.newBuilder("wasm");
		Source.Builder sourceBuilder = Source.newBuilder("wasm", ByteSequence.create(binary), "main");
		Source source = sourceBuilder.build();

		try (Context context = contextBuilder.allowAllAccess(true).build()) {

			context.eval(source);

			Value wasmProgram = context.getBindings("wasm");
			wasmProgram.getMemberKeys().forEach(System.out::println);

			Value mainFunction = wasmProgram.getMember("main");
			mainFunction.execute();
		}

	}

}
