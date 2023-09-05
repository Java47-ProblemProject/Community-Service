package telran.community.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import telran.community.dao.CommunityRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Component
@RequiredArgsConstructor
public class CommunitiesToFill {
    private final CommunityRepository communityRepository;

    private Map<String, String> fillCommunitiesMathematics() {
        Map<String, String> scientificFieldsWithDescriptions = new HashMap<>();
        scientificFieldsWithDescriptions.put("Mathematics", "The study of numbers, quantities, shapes, and patterns.");
        scientificFieldsWithDescriptions.put("Algebra", "The branch of mathematics dealing with symbols and the rules for manipulating those symbols.");
        scientificFieldsWithDescriptions.put("Geometry", "The study of shapes, sizes, properties, and dimensions of objects and spaces.");
        scientificFieldsWithDescriptions.put("Analysis", "The branch of mathematics that focuses on limits, continuity, and calculus.");
        scientificFieldsWithDescriptions.put("Number Theory", "The study of the properties and relationships of numbers, especially integers.");
        scientificFieldsWithDescriptions.put("Linear Algebra", "The study of vector spaces and linear mappings between these spaces.");
        scientificFieldsWithDescriptions.put("Differential Equations", "The study of equations involving derivatives and their solutions.");
        scientificFieldsWithDescriptions.put("Probability Theory", "The branch of mathematics that deals with uncertainty and randomness.");
        scientificFieldsWithDescriptions.put("Statistics", "The study of data collection, analysis, interpretation, and presentation.");
        scientificFieldsWithDescriptions.put("Combinatorics", "The study of counting, arrangement, and combination of objects.");
        scientificFieldsWithDescriptions.put("Topology", "The study of properties of space that are preserved under continuous transformations.");
        scientificFieldsWithDescriptions.put("Mathematical Logic", "The study of formal systems, proof theory, and mathematical reasoning.");
        scientificFieldsWithDescriptions.put("Cryptography", "The study of secure communication techniques.");
        scientificFieldsWithDescriptions.put("Mathematical Physics", "The application of mathematical methods to solve physical problems.");
        scientificFieldsWithDescriptions.put("Discrete Mathematics", "The study of mathematical structures that are fundamentally discrete rather than continuous.");
        scientificFieldsWithDescriptions.put("Numerical Analysis", "The study of algorithms for approximating solutions to mathematical problems.");
        scientificFieldsWithDescriptions.put("Operations Research", "The application of mathematical methods to decision-making and optimization.");
        scientificFieldsWithDescriptions.put("Mathematical Modeling", "The process of creating mathematical representations of real-world systems.");
        scientificFieldsWithDescriptions.put("Actuarial Science", "The study of risk assessment and financial mathematics.");
        scientificFieldsWithDescriptions.put("Complex Analysis", "The study of complex numbers and functions of a complex variable.");
        scientificFieldsWithDescriptions.put("Functional Analysis", "The study of vector spaces with a focus on linear operators and function spaces.");
        scientificFieldsWithDescriptions.put("Mathematical Statistics", "The application of statistical methods to analyze data.");
        scientificFieldsWithDescriptions.put("Discrete Geometry", "The study of geometry with a focus on discrete sets of points.");
        scientificFieldsWithDescriptions.put("Algebraic Geometry", "The study of solutions of polynomial equations.");
        scientificFieldsWithDescriptions.put("Computer Algebra", "The study of algorithms for symbolic computation.");
        scientificFieldsWithDescriptions.put("Graph Theory", "The study of graphs and their properties.");
        scientificFieldsWithDescriptions.put("Mathematical Optimization", "The study of finding the best solution in a set of possible solutions.");
        scientificFieldsWithDescriptions.put("Group Theory", "The study of algebraic structures known as groups.");
        scientificFieldsWithDescriptions.put("Algorithm Theory", "The study of algorithms and their efficiency.");
        scientificFieldsWithDescriptions.put("Information Theory", "The study of information and its transmission.");
        scientificFieldsWithDescriptions.put("Game Theory", "The study of strategic interactions between rational decision-makers.");
        scientificFieldsWithDescriptions.put("Geometric Number Theory", "The study of number theory with a geometric approach.");
        scientificFieldsWithDescriptions.put("Analytic Geometry", "The study of geometry with a focus on coordinates and equations.");
        scientificFieldsWithDescriptions.put("Multivariable Calculus", "The study of calculus involving multiple variables.");
        scientificFieldsWithDescriptions.put("Computational Geometry", "The study of algorithms for solving geometric problems.");
        scientificFieldsWithDescriptions.put("Mathematical Logic and Foundations of Mathematics", "The study of the logical and foundational basis of mathematics.");
        scientificFieldsWithDescriptions.put("Geometric Topology", "The study of topology with a focus on geometric properties.");
        scientificFieldsWithDescriptions.put("Numerical Linear Algebra", "The study of numerical methods for solving linear algebra problems.");
        scientificFieldsWithDescriptions.put("Complex Geometry", "The study of complex manifolds and complex algebraic varieties.");
        scientificFieldsWithDescriptions.put("Functional Calculus", "The study of calculus involving functional spaces.");
        scientificFieldsWithDescriptions.put("Analytic Number Theory", "The study of number theory using analytic methods.");
        scientificFieldsWithDescriptions.put("Graph Theory and Combinatorics", "The study of both graph theory and combinatorics.");
        scientificFieldsWithDescriptions.put("Algebraic Topology", "The study of topological spaces using algebraic methods.");
        scientificFieldsWithDescriptions.put("Operator Theory", "The study of linear operators on functional spaces.");
        scientificFieldsWithDescriptions.put("Projective Geometry", "The study of geometric properties preserved under projective transformations.");
        scientificFieldsWithDescriptions.put("Mathematical Biology", "The application of mathematical models to biological systems.");
        scientificFieldsWithDescriptions.put("Category Theory", "The study of abstract algebraic structures and their relationships.");
        scientificFieldsWithDescriptions.put("Boundary Value Problems Theory", "The study of solutions to differential equations with boundary conditions.");
        return scientificFieldsWithDescriptions;
    }

    private Map<String, String> fillCommunitiesPhysics() {
        Map<String, String> scientificFieldsWithDescriptions = new HashMap<>();
        scientificFieldsWithDescriptions.put("Classical Mechanics", "The study of the motion of objects and the forces acting on them.");
        scientificFieldsWithDescriptions.put("Quantum Mechanics", "The branch of physics that deals with the behavior of particles on a very small scale.");
        scientificFieldsWithDescriptions.put("Electromagnetism", "The study of the electromagnetic force, which includes electricity and magnetism.");
        scientificFieldsWithDescriptions.put("Thermodynamics", "The study of heat and energy transfer.");
        scientificFieldsWithDescriptions.put("Relativity", "The theory of space, time, and gravity, including special and general relativity.");
        scientificFieldsWithDescriptions.put("Optics", "The study of light and its interactions with matter.");
        scientificFieldsWithDescriptions.put("Nuclear Physics", "The study of the atomic nucleus and its interactions.");
        scientificFieldsWithDescriptions.put("Particle Physics", "The study of subatomic particles and their interactions.");
        scientificFieldsWithDescriptions.put("Astrophysics", "The study of celestial objects and phenomena in the universe.");
        scientificFieldsWithDescriptions.put("Cosmology", "The study of the origin, structure, and evolution of the universe.");
        scientificFieldsWithDescriptions.put("Plasma Physics", "The study of ionized gases, or plasmas.");
        scientificFieldsWithDescriptions.put("Solid-State Physics", "The study of the physical properties of solid materials.");
        scientificFieldsWithDescriptions.put("Fluid Dynamics", "The study of the motion of fluids, including liquids and gases.");
        scientificFieldsWithDescriptions.put("Acoustics", "The study of sound and its transmission.");
        scientificFieldsWithDescriptions.put("Biophysics", "The application of physics principles to biological systems.");
        scientificFieldsWithDescriptions.put("Condensed Matter Physics", "The study of the physical properties of condensed phases of matter.");
        scientificFieldsWithDescriptions.put("Atomic Physics", "The study of the behavior of atoms and their constituents.");
        scientificFieldsWithDescriptions.put("Optoelectronics", "The study of the interaction between light and electronic devices.");
        scientificFieldsWithDescriptions.put("High-Energy Physics", "The study of particle physics at very high energies.");
        scientificFieldsWithDescriptions.put("Materials Science", "The study of the properties and applications of materials.");
        scientificFieldsWithDescriptions.put("Plasma Astrophysics", "The study of plasmas in astrophysical contexts.");
        scientificFieldsWithDescriptions.put("Theoretical Physics", "The development of mathematical models and theories to explain physical phenomena.");
        scientificFieldsWithDescriptions.put("Experimental Physics", "The conduct of experiments to investigate physical phenomena.");
        scientificFieldsWithDescriptions.put("Medical Physics", "The application of physics principles to medical imaging and therapy.");
        scientificFieldsWithDescriptions.put("Nanotechnology", "The study and manipulation of nanoscale structures.");
        scientificFieldsWithDescriptions.put("Magnetism", "The study of magnetic fields and their effects.");
        scientificFieldsWithDescriptions.put("Geophysics", "The study of the Earth's physical properties and processes.");
        scientificFieldsWithDescriptions.put("Particle Accelerators", "Devices used to accelerate charged particles.");
        scientificFieldsWithDescriptions.put("Quantum Field Theory", "A theoretical framework combining quantum mechanics and special relativity.");
        scientificFieldsWithDescriptions.put("Superconductivity", "The phenomenon of zero electrical resistance in certain materials.");
        scientificFieldsWithDescriptions.put("Astronomy", "The study of celestial objects and phenomena beyond Earth's atmosphere.");
        scientificFieldsWithDescriptions.put("Astrobiology", "The study of the origin and potential for life in the universe.");
        scientificFieldsWithDescriptions.put("Atomic and Molecular Physics", "The study of the structure and behavior of atoms and molecules.");
        scientificFieldsWithDescriptions.put("Radiation Physics", "The study of ionizing radiation and its applications.");
        scientificFieldsWithDescriptions.put("Theoretical Astrophysics", "The development of theoretical models to explain astronomical observations.");
        scientificFieldsWithDescriptions.put("Plasma Fusion", "The study of controlled nuclear fusion as a potential energy source.");
        scientificFieldsWithDescriptions.put("Quantum Computing", "The use of quantum phenomena to perform computation.");
        scientificFieldsWithDescriptions.put("Gravitational Physics", "The study of gravity and its effects on the universe.");
        scientificFieldsWithDescriptions.put("Spectroscopy", "The study of the interaction between matter and electromagnetic radiation.");
        scientificFieldsWithDescriptions.put("Chaos Theory", "The study of deterministic systems with unpredictable outcomes.");
        scientificFieldsWithDescriptions.put("Experimental Condensed Matter Physics", "The investigation of the properties of condensed matter through experiments.");
        scientificFieldsWithDescriptions.put("Applied Physics", "The application of physical principles to practical problems and technologies.");
        scientificFieldsWithDescriptions.put("Neutrino Physics", "The study of neutrinos and their properties.");
        scientificFieldsWithDescriptions.put("Plasma Chemistry", "The study of chemical reactions in plasmas.");
        scientificFieldsWithDescriptions.put("Fluid Mechanics", "The study of the behavior of fluids at rest and in motion.");
        scientificFieldsWithDescriptions.put("Nuclear Fusion", "The process of combining atomic nuclei to release energy.");
        scientificFieldsWithDescriptions.put("Particle Detectors", "Devices used to detect and measure subatomic particles.");
        scientificFieldsWithDescriptions.put("Nuclear Reactor Physics", "The study of the behavior of nuclear reactors.");
        scientificFieldsWithDescriptions.put("Radiation Oncology Physics", "The use of physics in cancer treatment using radiation therapy.");
        scientificFieldsWithDescriptions.put("Nuclear Magnetic Resonance (NMR)", "A technique for studying the structure and dynamics of molecules.");
        return scientificFieldsWithDescriptions;
    }

    private Map<String, String> fillCommunitiesChemistry() {
        Map<String, String> scientificFieldsWithDescriptions = new HashMap<>();
        scientificFieldsWithDescriptions.put("Organic Chemistry", "The study of carbon-containing compounds.");
        scientificFieldsWithDescriptions.put("Inorganic Chemistry", "The study of inorganic compounds and materials.");
        scientificFieldsWithDescriptions.put("Physical Chemistry", "The study of the physical properties and behavior of chemical systems.");
        scientificFieldsWithDescriptions.put("Analytical Chemistry", "The study of methods for analyzing chemical substances.");
        scientificFieldsWithDescriptions.put("Biochemistry", "The study of chemical processes in living organisms.");
        scientificFieldsWithDescriptions.put("Medicinal Chemistry", "The design and development of pharmaceutical agents.");
        scientificFieldsWithDescriptions.put("Materials Chemistry", "The study of the properties and applications of materials.");
        scientificFieldsWithDescriptions.put("Environmental Chemistry", "The study of chemical processes in the environment.");
        scientificFieldsWithDescriptions.put("Theoretical Chemistry", "The development of mathematical models to explain chemical phenomena.");
        scientificFieldsWithDescriptions.put("Nanotechnology", "The study and manipulation of nanoscale materials and structures.");
        scientificFieldsWithDescriptions.put("Supramolecular Chemistry", "The study of non-covalent interactions between molecules.");
        scientificFieldsWithDescriptions.put("Chemical Engineering", "The application of chemical principles to industrial processes.");
        scientificFieldsWithDescriptions.put("Polymer Chemistry", "The study of polymers, large molecules made up of repeating units.");
        scientificFieldsWithDescriptions.put("Surface Chemistry", "The study of chemical reactions at interfaces.");
        scientificFieldsWithDescriptions.put("Coordination Chemistry", "The study of coordination compounds and their properties.");
        scientificFieldsWithDescriptions.put("Thermochemistry", "The study of heat energy changes in chemical reactions.");
        scientificFieldsWithDescriptions.put("Electrochemistry", "The study of chemical processes involving the movement of electrons.");
        scientificFieldsWithDescriptions.put("Chemical Kinetics", "The study of the rates of chemical reactions.");
        scientificFieldsWithDescriptions.put("Solid-State Chemistry", "The study of chemical compounds in the solid state.");
        scientificFieldsWithDescriptions.put("Organometallic Chemistry", "The study of compounds containing metal-to-carbon bonds.");
        scientificFieldsWithDescriptions.put("Chemical Thermodynamics", "The study of energy changes in chemical systems.");
        scientificFieldsWithDescriptions.put("Heterocyclic Chemistry", "The study of cyclic compounds containing at least one heteroatom.");
        scientificFieldsWithDescriptions.put("Green Chemistry", "The design of chemical products and processes that reduce environmental impact.");
        scientificFieldsWithDescriptions.put("Food Chemistry", "The study of chemical processes in food production and preservation.");
        scientificFieldsWithDescriptions.put("Photochemistry", "The study of chemical reactions involving light.");
        scientificFieldsWithDescriptions.put("Chemical Biology", "The interface between chemistry and biology.");
        scientificFieldsWithDescriptions.put("Industrial Chemistry", "The application of chemistry in industrial manufacturing.");
        scientificFieldsWithDescriptions.put("Bioinorganic Chemistry", "The study of the role of metal ions in biological systems.");
        scientificFieldsWithDescriptions.put("Chemical Education", "The study and improvement of chemistry education methods.");
        scientificFieldsWithDescriptions.put("Forensic Chemistry", "The application of chemistry to solve crimes.");
        scientificFieldsWithDescriptions.put("Chemical Safety", "The study of safe handling and storage of chemicals.");
        scientificFieldsWithDescriptions.put("Astrochemistry", "The study of chemical processes in outer space.");
        scientificFieldsWithDescriptions.put("Chemical Ecology", "The study of chemical interactions in ecological systems.");
        scientificFieldsWithDescriptions.put("Chemoinformatics", "The use of computer technology in chemistry.");
        scientificFieldsWithDescriptions.put("Chemical Instrumentation", "The development of analytical instruments for chemical analysis.");
        scientificFieldsWithDescriptions.put("Chemoenzymatics", "The study of enzymes in chemical synthesis.");
        scientificFieldsWithDescriptions.put("Chemical Toxicology", "The study of the toxic effects of chemicals.");
        scientificFieldsWithDescriptions.put("Chemical Physics", "The intersection of chemistry and physics.");
        scientificFieldsWithDescriptions.put("Chemical Oceanography", "The study of chemical processes in the oceans.");
        scientificFieldsWithDescriptions.put("Chemical Meteorology", "The study of chemical processes in the atmosphere.");
        scientificFieldsWithDescriptions.put("Chemical Geology", "The study of chemical processes in the Earth's crust.");
        scientificFieldsWithDescriptions.put("Chemical Archaeology", "The use of chemistry in archaeological research.");
        scientificFieldsWithDescriptions.put("Chemical History", "The historical study of chemistry and its development.");
        scientificFieldsWithDescriptions.put("Chemical Art", "The use of chemistry in art conservation and restoration.");
        scientificFieldsWithDescriptions.put("Chemical Journalism", "The reporting and communication of chemical information.");
        scientificFieldsWithDescriptions.put("Chemical Ethics", "The study of ethical issues in chemistry.");
        scientificFieldsWithDescriptions.put("Chemical Policy", "The development of policies related to chemical safety and regulation.");
        scientificFieldsWithDescriptions.put("Chemical Law", "The legal aspects of chemical regulation and liability.");
        scientificFieldsWithDescriptions.put("Chemical Economics", "The study of economic factors in the chemical industry.");
        scientificFieldsWithDescriptions.put("Chemical Marketing", "The promotion and sales of chemical products.");
        scientificFieldsWithDescriptions.put("Chemical Patents", "The legal protection of chemical inventions.");
        scientificFieldsWithDescriptions.put("Chemical Consulting", "The provision of expert advice in chemical-related matters.");
        return scientificFieldsWithDescriptions;
    }

    private void fill(Map<String, String> set) {
        for (Map.Entry<String, String> entry : set.entrySet()) {
            String name = entry.getKey();
            String description = entry.getValue();
            Community community = new Community();
            community.setName(name);
            community.setDescription(description);

            // Создаем копию subCommunities, исключая текущую область
            Set<String> subCommunities = new HashSet<>(set.keySet());
            subCommunities.remove(name);
            community.addSubCommunities(subCommunities);

            communityRepository.save(community);
        }
    }

    public void fillAllCommunities() {
        Map<String, String> mathFields = fillCommunitiesMathematics();
        Map<String, String> physicsFields = fillCommunitiesPhysics();
        Map<String, String> chemistryFields = fillCommunitiesChemistry();
        fill(mathFields);
        fill(physicsFields);
        fill(chemistryFields);
    }
}
