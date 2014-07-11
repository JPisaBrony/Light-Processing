package LightProcessing.LightTweeks;

import java.util.Iterator;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

import net.minecraft.launchwrapper.IClassTransformer;

public class LightTweeksTransformer implements IClassTransformer, Opcodes {

	@Override
	public byte[] transform(String name, String newName, byte[] bytes) {
		if (name.equals("abw"))
			return overrideLightMethods(name, bytes, false);
		if (name.equals("net.minecraft.world.World"))
			return overrideLightMethods(name, bytes, true);
		return bytes;
	}

	public byte[] overrideLightMethods(String name, byte[] bytes, boolean dev) {
		String methodToReplace;
		if (!dev)
			methodToReplace = "a";
		else
			methodToReplace = "computeLightValue";

		ClassNode classNode = new ClassNode();
		ClassReader classReader = new ClassReader(bytes);
		classReader.accept(classNode, 0);
		
		@SuppressWarnings("unchecked")
		Iterator<MethodNode> methods = classNode.methods.iterator();
		while (methods.hasNext()) {
			MethodNode m = methods.next();
			if ((m.name.equals(methodToReplace) && m.desc.equals("(IIILnet/minecraft/world/EnumSkyBlock;)I"))) {
				
				@SuppressWarnings("unchecked")
				Iterator<AbstractInsnNode> iter = m.instructions.iterator();
				
				// removes all instructions in the method
				while(iter.hasNext()) {
					m.instructions.remove(iter.next());
				}
				
				// inserts a call to updateLight method
				InsnList instList = new InsnList();
				instList.add(new VarInsnNode(ILOAD, 1));
				instList.add(new VarInsnNode(ILOAD, 2));
				instList.add(new VarInsnNode(ILOAD, 3));
				instList.add(new VarInsnNode(ALOAD, 4));
				instList.add(new VarInsnNode(ALOAD, 0));
				instList.add(new MethodInsnNode(INVOKESTATIC, "LightProcessing/LightTweeks/LightTweeksMethods", "updateLight", "(IIILnet/minecraft/world/EnumSkyBlock;Lnet/minecraft/world/World;)I"));
				instList.add(new InsnNode(IRETURN));
				m.instructions.insert(instList);
				/*
				Code to insert
				m.visitInsn(ILOAD);
				m.visitInsn(ILOAD);
				m.visitInsn(ILOAD);
				m.visitInsn(ILOAD);
				m.visitMethodInsn(INVOKESTATIC, "LightProcessing/LightTweeks/LightTweeksMethods", "updateLight", "(IIILnet/minecraft/world/EnumSkyBlock;)I");
				m.visitInsn(IRETURN);
				/*
				mv = cw.visitMethod(ACC_PRIVATE, "computeLightValue", "(IIILnet/minecraft/world/EnumSkyBlock;)I", null, null);
				mv.visitCode();
				Label l0 = new Label();
				mv.visitLabel(l0);
				mv.visitLineNumber(3468, l0);
				mv.visitVarInsn(ILOAD, 1);
				mv.visitVarInsn(ILOAD, 2);
				mv.visitVarInsn(ILOAD, 3);
				mv.visitVarInsn(ALOAD, 4);
				mv.visitMethodInsn(INVOKESTATIC, "LightProcessing/LightTweeks/LightTweeksMethods", "updateLight", "(IIILnet/minecraft/world/EnumSkyBlock;)I", false);
				mv.visitInsn(IRETURN);
				Label l1 = new Label();
				mv.visitLabel(l1);
				mv.visitLocalVariable("this", "Lnet/minecraft/world/World;", null, l0, l1, 0);
				mv.visitLocalVariable("par1", "I", null, l0, l1, 1);
				mv.visitLocalVariable("par2", "I", null, l0, l1, 2);
				mv.visitLocalVariable("par3", "I", null, l0, l1, 3);
				mv.visitLocalVariable("par4EnumSkyBlock", "Lnet/minecraft/world/EnumSkyBlock;", null, l0, l1, 4);
				mv.visitMaxs(4, 5);
				mv.visitEnd();
				*/
			}
		}
		ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
		classNode.accept(writer);
		return writer.toByteArray();
	}

}
